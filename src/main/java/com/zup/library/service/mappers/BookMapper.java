package com.zup.library.service.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {
    public static Book forBook(BookRegisterDTO registerDTO){
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(registerDTO, Book.class);
    }

    public static List<BookResponseDTO> forResponse(List<Book> bookList){
        List<BookResponseDTO> dtoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        for(Book book : bookList ){
            BookResponseDTO bookResponseDTO = mapper.convertValue(book, BookResponseDTO.class);
            dtoList.add(bookResponseDTO);
        }

        return dtoList;
    }
}
