package com.zup.library.service.interfaces;

import com.zup.library.controllers.endUser.dtos.EndUserRegisterDTO;
import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;
import com.zup.library.controllers.endUser.dtos.EndUserUpdateDTO;

import java.util.List;

public interface EndUserService {
    void save (EndUserRegisterDTO endUserRegisterDTO);

    void update (Long id, EndUserUpdateDTO endUserUpdateDTO);

    void delete (Long id);

    List<EndUserResponseDTO> getAllUsers();
}
