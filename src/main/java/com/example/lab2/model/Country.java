package com.example.lab2.model;

import lombok.Data;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String continent;
}
