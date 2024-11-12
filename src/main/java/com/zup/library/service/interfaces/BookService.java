package com.zup.library.service.interfaces;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.models.Book;

import java.util.List;

public interface BookService {
    void save (BookRegisterDTO bookRegisterDTO);

    List<BookResponseDTO> getAll ();

    void delete (Long id);
}
