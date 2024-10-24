package com.zup.library.service.interfaces;

import com.zup.library.controllers.author.dtos.AuthorRegisterDTO;
import com.zup.library.controllers.author.dtos.AuthorUpdateDTO;

public interface AuthorService {
    void save (AuthorRegisterDTO authorRegisterDTO);

    void update (Long id, AuthorUpdateDTO authorUpdateDTO);
}
