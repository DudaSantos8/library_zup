package com.zup.library.service.interfaces;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;

public interface BookService {
    void save (BookRegisterDTO bookRegisterDTO);

    void delete (Long id);
}
