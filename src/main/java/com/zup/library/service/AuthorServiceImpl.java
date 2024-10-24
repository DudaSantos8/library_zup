package com.zup.library.service;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.controllers.author.dtos.AuthorUpdateDTO;
import com.zup.library.models.Author;
import com.zup.library.repositories.AuthorRepository;
import com.zup.library.service.interfaces.AuthorService;
import com.zup.library.service.mappers.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(AuthorRegisterDTO registerDTO) {
        authorRepository.save(AuthorMapper.forAuthor(registerDTO));
    }

    @Override
    public void update(Long id, AuthorUpdateDTO authorUpdateDTO) {
        Optional<Author> optional = authorRepository.findById(id);
        if(optional.isPresent()){
            optional.get().setName(authorUpdateDTO.getName());
            optional.get().setLastName(authorUpdateDTO.getLastName());
            optional.get().setYearOfBirth(authorUpdateDTO.getYearOfBirth());
            optional.get().setYearOfDeath(authorUpdateDTO.getYearOfDeath());
            authorRepository.save(optional.get());
        }else {
            throw new RuntimeException("This Author don't exist");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Author> optional = authorRepository.findById(id);
        if(optional.isPresent()){
            authorRepository.delete(optional.get());
        }else {
            throw new RuntimeException("This Author don't exist");
        }
    }


}
