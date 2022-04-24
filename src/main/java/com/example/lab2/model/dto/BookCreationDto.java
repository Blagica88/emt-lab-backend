package com.example.lab2.model.dto;

import com.example.lab2.model.Author;
import com.example.lab2.model.CategoryType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;


@Getter
@Setter
public class BookCreationDto {
    private Long id;

    private String name;

    private CategoryType categoryType;

    private Long author;

    private Integer availableCopies;
}
