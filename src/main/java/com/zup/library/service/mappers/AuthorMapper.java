package com.zup.library.service.mappers;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.models.Author;

public class AuthorMapper {
    public static Author forAuthor(AuthorRegisterDTO registerDTO){
        Author author = new Author();

        author.setName(registerDTO.getName());
        author.setLastName(registerDTO.getLastName());
        author.setYearOfBirth(registerDTO.getYearOfBirth());
        author.setYearOfDeath(registerDTO.getYearOfDeath());

        return author;
    }
}
