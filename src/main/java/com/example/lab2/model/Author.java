package com.example.lab2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private Country country;
}
