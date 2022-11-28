package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "status_question")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    public StatusQuestion (Long id){
        this.id = id;
    }
}
