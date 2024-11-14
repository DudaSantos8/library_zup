package com.zup.library.service;

import com.zup.library.controllers.book.dtos.BookRegisterDTO;
import com.zup.library.controllers.book.dtos.BookResponseDTO;
import com.zup.library.controllers.book.dtos.BookUpdateDTO;
import com.zup.library.models.Consumers;
import com.zup.library.models.Book;
import com.zup.library.repositories.ConsumerRepository;
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
    private ConsumerRepository consumerRepository;

    @Override
    public void save(BookRegisterDTO bookRegisterDTO) {
        for(Consumers consumer : bookRegisterDTO.getConsumers()){
            Optional<Consumers> userRepositoryOptional = consumerRepository.findById(consumer.getId());
            if(userRepositoryOptional.isEmpty()){
                throw new RuntimeException(consumer.getUsername() + " don't exist");
            }
        }
        bookRepository.save(BookMapper.forBook(bookRegisterDTO));
    }

    @Override
    public void update(String id,BookUpdateDTO bookUpdateDTO) {
        Optional<Book> optional = bookRepository.findById(id);
        Set<Consumers> consumers = new HashSet<>();
        if(optional.isPresent()){
            for(Consumers consumer : bookUpdateDTO.getConsumers()){
                Optional<Consumers> userRepositoryOptional = consumerRepository.findById(consumer.getId());
                if(userRepositoryOptional.isEmpty()){
                    throw new RuntimeException(consumer.getUsername() + " don't exist");
                }
                consumers.add(consumer);
            }
            optional.get().setTitle(bookUpdateDTO.getTitle());
            optional.get().setConsumers(consumers);
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
    public void delete (String id){
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent()){
            optional.get().getConsumers().clear();
            bookRepository.delete(optional.get());
        }else {
            throw new RuntimeException("This book don't exist");
        }
    }
}
