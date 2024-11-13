package com.zup.library.service.interfaces;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.controllers.book.dtos.BookUpdateDTO;

import java.util.List;

public interface BookService {
    void save (BookRegisterDTO bookRegisterDTO);

    void update(String id, BookUpdateDTO bookUpdateDTO);

    List<BookResponseDTO> getAll ();

    void delete (String id);
}
