package com.zup.library.controllers;

import com.zup.library.controllers.endUser.dtos.ConsumerRegisterDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerResponseDTO;
import com.zup.library.controllers.endUser.dtos.ConsumerUpdateDTO;
import com.zup.library.service.interfaces.ConsumerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/test")
    public List<ConsumerResponseDTO> showConsumers(){
        return consumerService.getAllConsumers();
    }

    @PostMapping
    public void saveConsumer(@RequestBody @Valid ConsumerRegisterDTO registerDTO){
        consumerService.save(registerDTO);
    }

    @PutMapping("/{username}")
    public void updateConsumer(@PathVariable String username, @RequestBody @Valid ConsumerUpdateDTO updateDTO){
        consumerService.update(username, updateDTO);
    }

    @DeleteMapping("/{username}")
    public void deleteConsumer(@PathVariable String username){
        consumerService.delete(username);
    }
}
