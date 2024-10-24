package com.zup.library.service;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.repositories.AuthorRepository;
import com.zup.library.service.interfaces.AuthorService;
import com.zup.library.service.mappers.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(AuthorRegisterDTO registerDTO) {
        authorRepository.save(AuthorMapper.forAuthor(registerDTO));
    }
}
