package com.zup.library.controllers.book.dtos;

import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class BookResponseDTO {

    private Long id;
    private String title;
    private String description;
    private List<EndUserResponseDTO> author = new ArrayList<>();

    public BookResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<EndUserResponseDTO> getAuthor() {
        return author;
    }

    public void setAuthor(List<EndUserResponseDTO> author) {
        this.author = author;
    }
}
