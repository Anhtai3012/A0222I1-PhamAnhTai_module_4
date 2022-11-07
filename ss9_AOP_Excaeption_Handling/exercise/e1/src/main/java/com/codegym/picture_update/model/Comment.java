package com.codegym.picture_update.model;

import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.*;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "vote")
    private int vote;

    @Column(name = "author")
    private String author;

    @Column(name = "feedback")
    private String feedback;

    @Column(name="liked", nullable = false)
    private int liked = 0;

    @ManyToOne
//    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "picture_id")
    private Picture picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
