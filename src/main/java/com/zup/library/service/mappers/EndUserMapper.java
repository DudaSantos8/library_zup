package com.zup.library.service.mappers;

import com.zup.library.controllers.endUser.dtos.EndUserRegisterDTO;
import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;
import com.zup.library.models.Consumers;
import com.zup.library.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EndUserMapper {

    public static Consumers forUser(EndUserRegisterDTO registerDTO, String password, Set<Role> roles){
        Consumers endUser = new Consumers();

        endUser.setName(registerDTO.getName());
        endUser.setLastName(registerDTO.getLastName());
        endUser.setYearOfBirth(registerDTO.getYearOfBirth());
        endUser.setYearOfDeath(registerDTO.getYearOfDeath());
        endUser.setPassword(password);
        endUser.setRoles(roles);

        return endUser;
    }

    private static EndUserResponseDTO forUserResponse(Consumers endUser){
        EndUserResponseDTO dto = new EndUserResponseDTO();

        dto.setId(endUser.getId());
        dto.setName(endUser.getName());
        dto.setLastName(endUser.getLastName());
        dto.setYearOfBirth(endUser.getYearOfBirth());
        dto.setYearOfDeath(endUser.getYearOfDeath());

        return dto;
    }

    public static List<EndUserResponseDTO> forUserResponse(List<Consumers> consumersList){
        List<EndUserResponseDTO> dtoList = new ArrayList<>();
        for (Consumers endUser : consumersList){
            dtoList.add(forUserResponse(endUser));
        }
        return dtoList;
    }

    public static List<EndUserResponseDTO> forUserResponse(Set<Consumers> consumersList){
        List<EndUserResponseDTO> dtoList = new ArrayList<>();
        for(Consumers endUser : consumersList){
            dtoList.add(forUserResponse(endUser));
        }
        return dtoList;
    }
}
