package com.zup.library.service;

import com.zup.library.controllers.endUser.dtos.EndUserRegisterDTO;
import com.zup.library.controllers.endUser.dtos.EndUserResponseDTO;
import com.zup.library.controllers.endUser.dtos.EndUserUpdateDTO;
import com.zup.library.models.Consumers;
import com.zup.library.models.Role;
import com.zup.library.repositories.ConsumerRepository;
import com.zup.library.repositories.RoleRepository;
import com.zup.library.service.interfaces.EndUserService;
import com.zup.library.service.mappers.EndUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EndUserServiceImpl implements EndUserService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(EndUserRegisterDTO registerDTO) {
        Optional<Consumers> optional = consumerRepository.findByName(registerDTO.getName());
        if(optional.isPresent()){
            throw new RuntimeException("This user already exist");
        }

        String password = passwordEncoder.encode(registerDTO.getPassword());
        Set<Role> roles = registerDTO.getRoles().stream().map(r -> new Role(r.getName())).collect(Collectors.toSet());
        roleRepository.saveAll(roles);

        consumerRepository.save(EndUserMapper.forUser(registerDTO, password, roles));
    }

    @Override
    public void update(String id, EndUserUpdateDTO endUserUpdateDTO) {
        Optional<Consumers> optional = consumerRepository.findById(id);
        if(optional.isPresent()){
            optional.get().setName(endUserUpdateDTO.getName());
            optional.get().setLastName(endUserUpdateDTO.getLastName());
            optional.get().setYearOfBirth(endUserUpdateDTO.getYearOfBirth());
            optional.get().setYearOfDeath(endUserUpdateDTO.getYearOfDeath());
            optional.get().setPassword(endUserUpdateDTO.getPassword());
            consumerRepository.save(optional.get());
        }else {
            throw new RuntimeException("This user don't exist");
        }
    }

    @Override
    public void delete(String id) {
        Optional<Consumers> optional = consumerRepository.findById(id);
        if(optional.isPresent()){
            if(optional.get().getBook().isEmpty()){
                consumerRepository.delete(optional.get());
            }else {
                throw new RuntimeException("This user have books");
            }
        }else {
            throw new RuntimeException("This user don't exist");
        }
    }

    @Override
    public List<EndUserResponseDTO> getAllUsers() {
        List<Consumers> consumers = consumerRepository.findAll();
        return EndUserMapper.forUserResponse(consumers);
    }


}
