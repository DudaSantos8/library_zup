package com.zup.library.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int yearOfBirth;
    private int yearOfDeath;

    @ManyToMany(mappedBy = "author")
    private Set<Book> book = new HashSet<>();

    public Author() {
    }


}
