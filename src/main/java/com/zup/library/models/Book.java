package com.zup.library.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private String title;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
               joinColumns = @JoinColumn(name = "book_fk"),
               inverseJoinColumns = @JoinColumn(name = "author_fk"))
    private Set<Author> author = new HashSet<>();
}
