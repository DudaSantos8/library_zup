package com.zup.library.service.mappers;

import com.zup.library.controllers.endUser.dtos.EndUserRegisterDTO;
import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;
import com.zup.library.models.EndUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EndUserMapper {
    public static EndUser forUser(EndUserRegisterDTO registerDTO){
        EndUser endUser = new EndUser();

        endUser.setName(registerDTO.getName());
        endUser.setLastName(registerDTO.getLastName());
        endUser.setYearOfBirth(registerDTO.getYearOfBirth());
        endUser.setYearOfDeath(registerDTO.getYearOfDeath());

        return endUser;
    }

    private static EndUserResponseDTO forUserResponse(EndUser endUser){
        EndUserResponseDTO dto = new EndUserResponseDTO();

        dto.setId(endUser.getId());
        dto.setName(endUser.getName());
        dto.setLastName(endUser.getLastName());
        dto.setYearOfBirth(endUser.getYearOfBirth());
        dto.setYearOfDeath(endUser.getYearOfDeath());

        return dto;
    }

    public static List<EndUserResponseDTO> forUserResponse(List<EndUser> endUserList){
        List<EndUserResponseDTO> dtoList = new ArrayList<>();
        for (EndUser endUser : endUserList){
            dtoList.add(forUserResponse(endUser));
        }
        return dtoList;
    }

    public static List<EndUserResponseDTO> forUserResponse(Set<EndUser> endUserList){
        List<EndUserResponseDTO> dtoList = new ArrayList<>();
        for(EndUser endUser : endUserList){
            dtoList.add(forUserResponse(endUser));
        }
        return dtoList;
    }
}
