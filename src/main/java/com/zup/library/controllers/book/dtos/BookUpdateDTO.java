package com.zup.library.controllers.book.dtos;

import com.zup.library.models.Author;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class BookUpdateDTO {

    @Size(min = 3, message = "title not valid")
    private String title;

    @NotNull(message = "this field can't be null")
    private String description;

    @Size(max = 5, message = "this book can't have more than  five authors")
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
