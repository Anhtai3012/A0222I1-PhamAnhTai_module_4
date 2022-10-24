package com.codegym.e2.model;

import com.codegym.e2.utils.ValidateGenre;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Song implements Validator {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 800,message = "not exist")
    @Column(name = "name")
    private String nameSong;

    @NotBlank
    @Size(max = 300,message = "")
    @Column(name = "singer")
    private String singer;

    @NotBlank
    @Size(max = 1000, message = "")
    @ValidateGenre
    @Column(name = "genre")
    private String genre;

    public Song() {
    }

    public Song(Integer id, @NotBlank @Size(max = 800, message = "not exist") @Pattern(regexp = "[$&+,:;=?@#|'<>.-^*()%!]", message = "not special character") String nameSong, @Size(max = 300, message = "") @Pattern(regexp = "[$&+,:;=?@#|'<>.-^*()%!]", message = "not special character") String singer, @Size(max = 1000, message = "") @Pattern(regexp = "[$&+:;=?@#|'<>.-^*()%!]", message = "not special character") String genre) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if (song.nameSong.matches("^[$&+,:;=?@#|'<>.-^*()%!]{1,}$")){
            errors.rejectValue("nameSong","nameSong.invalidFormat");
        }
        if (song.singer.matches("^[$&+,:;=?@#|'<>.-^*()%!]{1,}$")){
            errors.rejectValue("singer","singer.invalidFormat");
        }
    }
}
