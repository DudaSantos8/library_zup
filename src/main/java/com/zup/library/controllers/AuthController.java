package com.zup.library.controllers;


import com.zup.library.controllers.endUser.dtos.AuthResponseDto;
import com.zup.library.controllers.endUser.dtos.LoginDTO;
import com.zup.library.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        Map<String, String> token = authService.login(loginDTO);

        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setToken(token);

        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }
}
