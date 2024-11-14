package com.zup.library.service;

import com.zup.library.controllers.endUser.dtos.ConsumerRegisterDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerResponseDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerUpdateDTO;
import com.zup.library.models.Consumers;
import com.zup.library.models.Role;
import com.zup.library.repositories.ConsumerRepository;
import com.zup.library.repositories.RoleRepository;
import com.zup.library.service.interfaces.ConsumerService;
import com.zup.library.service.mappers.ConsumerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(ConsumerRegisterDTO registerDTO) {
        if(consumerRepository.existsByUsername(registerDTO.getUsername())){
            throw new RuntimeException("This consumer already exist");
        }

        String password = passwordEncoder.encode(registerDTO.getPassword());
        Set<Role> roles = registerDTO.getRoles().stream().map(r -> new Role(r.getName())).collect(Collectors.toSet());
        roleRepository.saveAll(roles);

        consumerRepository.save(ConsumerMapper.forUser(registerDTO, password, roles));
    }

    @Override
    public void update(String username, ConsumerUpdateDTO consumerUpdateDTO) {
        if(consumerRepository.existsByUsername(consumerUpdateDTO.getUsername())){
            Optional<Consumers> consumerBd = consumerRepository.
                    findByUsername(consumerUpdateDTO.getUsername());

            consumerBd.get().setUsername(consumerUpdateDTO.getUsername());
            consumerBd.get().setLastName(consumerUpdateDTO.getLastName());
            consumerBd.get().setYearOfBirth(consumerUpdateDTO.getYearOfBirth());
            consumerBd.get().setYearOfDeath(consumerUpdateDTO.getYearOfDeath());
            consumerBd.get().setPassword(consumerUpdateDTO.getPassword());
            consumerBd.get().setRoles(consumerUpdateDTO.getRoles());

            consumerRepository.save(consumerBd.get());
        }else {
            throw new RuntimeException("This consumer don't exist");
        }
    }

    @Override
    public void delete(String username) {
        if(consumerRepository.existsByUsername(username)){

            Optional<Consumers> consumers = consumerRepository.findByUsername(username);

            if(consumers.get().getBook().isEmpty()){
                consumerRepository.delete(consumers.get());
            }else {
                throw new RuntimeException("This consumer have books");
            }
        }else {
            throw new RuntimeException("This consumer don't exist");
        }
    }

    @Override
    public List<ConsumerResponseDTO> getAllConsumers() {
        List<Consumers> consumers = consumerRepository.findAll();
        return ConsumerMapper.forUserResponse(consumers);
    }


}
