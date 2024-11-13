package com.zup.library.service;

import com.zup.library.controllers.endUser.dtos.EndUserRegisterDTO;
import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;
import com.zup.library.controllers.endUser.dtos.EndUserUpdateDTO;
import com.zup.library.models.EndUser;
import com.zup.library.repositories.EndUserRepository;
import com.zup.library.service.interfaces.EndUserService;
import com.zup.library.service.mappers.EndUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EndUserServiceImpl implements EndUserService {

    @Autowired
    private EndUserRepository endUserRepository;

    @Override
    public void save(EndUserRegisterDTO registerDTO) {
        Optional<EndUser> optional = endUserRepository.findByName(registerDTO.getName());
        if(optional.isPresent()){
            throw new RuntimeException("This user already exist");
        }
        endUserRepository.save(EndUserMapper.forUser(registerDTO));
    }

    @Override
    public void update(String id, EndUserUpdateDTO endUserUpdateDTO) {
        Optional<EndUser> optional = endUserRepository.findById(id);
        if(optional.isPresent()){
            optional.get().setName(endUserUpdateDTO.getName());
            optional.get().setLastName(endUserUpdateDTO.getLastName());
            optional.get().setYearOfBirth(endUserUpdateDTO.getYearOfBirth());
            optional.get().setYearOfDeath(endUserUpdateDTO.getYearOfDeath());
            endUserRepository.save(optional.get());
        }else {
            throw new RuntimeException("This user don't exist");
        }
    }

    @Override
    public void delete(String id) {
        Optional<EndUser> optional = endUserRepository.findById(id);
        if(optional.isPresent()){
            if(optional.get().getBook().isEmpty()){
                endUserRepository.delete(optional.get());
            }else {
                throw new RuntimeException("This user have books");
            }
        }else {
            throw new RuntimeException("This user don't exist");
        }
    }

    @Override
    public List<EndUserResponseDTO> getAllUsers() {
        List<EndUser> endUsers = endUserRepository.findAll();
        return EndUserMapper.forUserResponse(endUsers);
    }


}
