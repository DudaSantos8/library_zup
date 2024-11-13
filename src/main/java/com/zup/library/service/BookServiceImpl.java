package com.zup.library.service;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.controllers.book.dtos.BookUpdateDTO;
import com.zup.library.models.EndUser;
import com.zup.library.models.Book;
import com.zup.library.repositories.EndUserRepository;
import com.zup.library.repositories.BookRepository;
import com.zup.library.service.interfaces.BookService;
import com.zup.library.service.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EndUserRepository endUserRepository;

    @Override
    public void save(BookRegisterDTO bookRegisterDTO) {
        for(EndUser endUser : bookRegisterDTO.getAuthor()){
            Optional<EndUser> authorRepositoryOptional = endUserRepository.findById(endUser.getId());
            if(authorRepositoryOptional.isEmpty()){
                throw new RuntimeException(endUser.getName() + " don't exist");
            }
        }
        bookRepository.save(BookMapper.forBook(bookRegisterDTO));
    }

    @Override
    public void update(Long id,BookUpdateDTO bookUpdateDTO) {
        Optional<Book> optional = bookRepository.findById(id);
        Set<EndUser> endUsers = new HashSet<>();
        if(optional.isPresent()){
            for(EndUser endUser : bookUpdateDTO.getAuthor()){
                Optional<EndUser> authorRepositoryOptional = endUserRepository.findById(endUser.getId());
                if(authorRepositoryOptional.isEmpty()){
                    throw new RuntimeException(endUser.getName() + " don't exist");
                }
                endUsers.add(endUser);
            }
            optional.get().setTitle(bookUpdateDTO.getTitle());
            optional.get().setAuthor(endUsers);
            optional.get().setDescription(bookUpdateDTO.getDescription());
            bookRepository.saveAndFlush(optional.get());
        }else {
            throw new RuntimeException("This Book don't exist");
        }
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
