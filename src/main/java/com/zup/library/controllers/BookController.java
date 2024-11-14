package com.zup.library.controllers;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.controllers.book.dtos.BookUpdateDTO;
import com.zup.library.service.interfaces.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookResponseDTO> getAllBooks(){
        return bookService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody @Valid BookRegisterDTO registerDTO){
        bookService.save(registerDTO);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable String id, @RequestBody @Valid BookUpdateDTO updateDTO){
        bookService.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.delete(id);
    }
}
