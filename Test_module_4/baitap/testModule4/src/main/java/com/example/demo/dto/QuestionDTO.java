package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class QuestionDTO {
    Long id;

    String answer;

    @NotBlank(message = "input something!!!")
    @Size(min = 5, max = 100)
    String title;

    @NotBlank(message = "input something!!!")
    @Size(min = 5, max = 500)
    String content;

    @NotBlank(message = "chose something!!!")
    String typeQuestion;

    String statusQuestion;
}
