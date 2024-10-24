package com.zup.library.controllers.book;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.models.Author;
import com.zup.library.repositories.AuthorRepository;
import com.zup.library.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody BookRegisterDTO registerDTO){
        for(Author author : registerDTO.getAuthor()){
            authorRepository.save(author);
        }
        bookService.save(registerDTO);
    }
}
