package com.example.lab2.model;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private CategoryType categoryType;

    @ManyToOne
    private Author author;

    private Integer availableCopies;
}
