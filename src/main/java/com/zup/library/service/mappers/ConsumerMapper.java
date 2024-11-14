package com.zup.library.service.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zup.library.controllers.endUser.dtos.ConsumerRegisterDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerResponseDTO;
import com.zup.library.models.Consumers;
import com.zup.library.models.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConsumerMapper {

    public static Consumers forUser(ConsumerRegisterDTO registerDTO, String password, Set<Role> roles){
        ObjectMapper mapper = new ObjectMapper();

        Consumers consumer = mapper.convertValue(registerDTO, Consumers.class);
        consumer.setPassword(password);
        consumer.setRoles(roles);
        return consumer;
    }

    private static ConsumerResponseDTO forUserResponse(Consumers consumer){
        ObjectMapper mapper = new ObjectMapper();

        return mapper.convertValue(consumer, ConsumerResponseDTO.class);
    }

    public static List<ConsumerResponseDTO> forUserResponse(List<Consumers> consumersList){
        List<ConsumerResponseDTO> dtoList = new ArrayList<>();
        for (Consumers endUser : consumersList){
            dtoList.add(forUserResponse(endUser));
        }
        return dtoList;
    }

    public static List<ConsumerResponseDTO> forUserResponse(Set<Consumers> consumersList){
        List<ConsumerResponseDTO> dtoList = new ArrayList<>();
        for(Consumers endUser : consumersList){
            dtoList.add(forUserResponse(endUser));
        }
        return dtoList;
    }
}
