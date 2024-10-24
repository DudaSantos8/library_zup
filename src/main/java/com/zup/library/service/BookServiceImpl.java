package com.zup.library.service;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.repositories.BookRepository;
import com.zup.library.service.interfaces.BookService;
import com.zup.library.service.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(BookRegisterDTO bookRegisterDTO) {
        bookRepository.save(BookMapper.forBook(bookRegisterDTO));
    }
}
