package com.zup.library.controllers.endUser.dtos;

import lombok.Data;

import java.util.Map;

@Data
public class AuthResponseDto {

    private Map<String, String> token;
}
