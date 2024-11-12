package com.zup.library.controllers.book.dtos;

import com.zup.library.models.Author;

import java.util.HashSet;
import java.util.Set;

public class BookUpdateDTO {

    private String title;
    private String description;
    private Set<Author> author = new HashSet<>();

    public BookUpdateDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Set<Author> author) {
        this.author = author;
    }
}
