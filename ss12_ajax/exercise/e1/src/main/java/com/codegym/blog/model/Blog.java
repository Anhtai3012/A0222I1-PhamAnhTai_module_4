package com.codegym.blog.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "blog")
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBlog;
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Blog() {
    }
}
