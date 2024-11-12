package com.zup.library.service;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.models.Author;
import com.zup.library.models.Book;
import com.zup.library.repositories.AuthorRepository;
import com.zup.library.repositories.BookRepository;
import com.zup.library.service.interfaces.BookService;
import com.zup.library.service.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(BookRegisterDTO bookRegisterDTO) {
        for(Author author : bookRegisterDTO.getAuthor()){
            authorRepository.save(author);
        }
        bookRepository.save(BookMapper.forBook(bookRegisterDTO));
    }

    @Override
    public List<BookResponseDTO> getAll() {
        List<Book> books = bookRepository.findAll();
        return BookMapper.forResponse(books);
    }

    @Override
    public void delete (Long id){
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent()){
            optional.get().getAuthor().clear();
            bookRepository.delete(optional.get());
        }else {
            throw new RuntimeException("This book don't exist");
        }
    }
}
