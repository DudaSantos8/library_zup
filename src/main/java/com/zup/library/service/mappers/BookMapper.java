package com.zup.library.service.mappers;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {
    public static Book forBook(BookRegisterDTO registerDTO){
        Book book = new Book();

        book.setTitle(registerDTO.getTitle());
        book.setDescription(registerDTO.getDescription());
        book.setEndUser(registerDTO.getEndUser());

        return book;
    }

    public static List<BookResponseDTO> forResponse(List<Book> bookList){
        List<BookResponseDTO> dtoList = new ArrayList<>();

        for(Book book : bookList ){
            BookResponseDTO responseDTO = new BookResponseDTO();
            responseDTO.setId(book.getId());
            responseDTO.setTitle(book.getTitle());
            responseDTO.setDescription(book.getDescription());
            responseDTO.setEndUsers(EndUserMapper.forUserResponse(book.getEndUser()));
            dtoList.add(responseDTO);
        }

        return dtoList;
    }
}
