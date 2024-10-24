package com.zup.library.service.mappers;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.models.Book;

public class BookMapper {
    public static Book forBook(BookRegisterDTO registerDTO){
        Book book = new Book();

        book.setTitle(registerDTO.getTitle());
        book.setDescription(registerDTO.getDescription());
        book.setAuthor(registerDTO.getAuthor());

        return book;
    }
}
