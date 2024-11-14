package com.zup.library.controllers.book.dtos;

import com.zup.library.models.Consumers;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class BookRegisterDTO {

    @Size(min = 3, message = "title not valid")
    private String title;

    @NotNull(message = "this field can't be null")
    private String description;

    @Size(max = 5, message = "this book can't have more than  five authors")
    private Set<Consumers> endUser = new HashSet<>();

    public BookRegisterDTO() {
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

    public Set<Consumers> getEndUser() {
        return endUser;
    }

    public void setEndUser(Set<Consumers> endUser) {
        this.endUser = endUser;
    }
}
