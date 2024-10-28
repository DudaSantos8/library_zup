package com.zup.library.service.interfaces;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.controllers.author.dtos.AuthorResponseDTO;
import com.zup.library.controllers.author.dtos.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {
    void save (AuthorRegisterDTO authorRegisterDTO);

    void update (Long id, AuthorUpdateDTO authorUpdateDTO);

    void delete (Long id);

    List<AuthorResponseDTO> getAllAuthor ();
}
