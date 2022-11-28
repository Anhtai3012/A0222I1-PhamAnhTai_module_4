package com.codegym.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "not empty")
    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "date",nullable = false)
    private Date date;

    @NotBlank(message = "not empty")
    @Column(name = "reporter",nullable = false)
    private String reporter;

    @NotBlank(message = "not empty")
    @Column(name = "title",nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false,referencedColumnName = "id")
    private Category category;
}
