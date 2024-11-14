package com.zup.library.service.interfaces;

import com.zup.library.controllers.endUser.dtos.ConsumerRegisterDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerResponseDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerUpdateDTO;

import java.util.List;

public interface ConsumerService {
    void save (ConsumerRegisterDTO consumerRegisterDTO);

    void update (String username, ConsumerUpdateDTO consumerUpdateDTO);

    void delete (String username);

    List<ConsumerResponseDTO> getAllConsumers();
}
