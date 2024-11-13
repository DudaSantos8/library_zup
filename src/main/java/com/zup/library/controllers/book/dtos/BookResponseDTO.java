package com.zup.library.controllers.book.dtos;

import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class BookResponseDTO {

    private String id;
    private String title;
    private String description;
    private List<EndUserResponseDTO> endUsers = new ArrayList<>();

    public BookResponseDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<EndUserResponseDTO> getEndUsers() {
        return endUsers;
    }

    public void setEndUsers(List<EndUserResponseDTO> endUsers) {
        this.endUsers = endUsers;
    }
}
