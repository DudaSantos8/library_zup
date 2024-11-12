package com.zup.library.service.mappers;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.controllers.author.dtos.AuthorResponseDTO;
import com.zup.library.models.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthorMapper {
    public static Author forAuthor(AuthorRegisterDTO registerDTO){
        Author author = new Author();

        author.setName(registerDTO.getName());
        author.setLastName(registerDTO.getLastName());
        author.setYearOfBirth(registerDTO.getYearOfBirth());
        author.setYearOfDeath(registerDTO.getYearOfDeath());

        return author;
    }

    public static List<AuthorResponseDTO> forAuthorResponse(List<Author> authorList){
        List<AuthorResponseDTO> dtoList = new ArrayList<>();
        for(Author author : authorList){
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setId(author.getId());
            dto.setName(author.getName());
            dto.setLastName(author.getLastName());
            dto.setYearOfBirth(author.getYearOfBirth());
            dto.setYearOfDeath(author.getYearOfDeath());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public static List<AuthorResponseDTO> forAuthorResponse(Set<Author> authorList){
        List<AuthorResponseDTO> dtoList = new ArrayList<>();
        for(Author author : authorList){
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setId(author.getId());
            dto.setName(author.getName());
            dto.setLastName(author.getLastName());
            dto.setYearOfBirth(author.getYearOfBirth());
            dto.setYearOfDeath(author.getYearOfDeath());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
