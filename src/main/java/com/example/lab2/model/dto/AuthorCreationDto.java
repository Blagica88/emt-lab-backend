package com.example.lab2.model.dto;

import com.example.lab2.model.Country;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthorCreationDto {
    private Long id;

    private String name;

    private String surname;

    private Long country;
}
