package com.zup.library.controllers.endUser.dtos;

import java.util.Map;

public class AuthResponseDto {
    private Map<String, String> token;

    public AuthResponseDto() {
    }

    public Map<String, String> getToken() {
        return token;
    }

    public void setToken(Map<String, String> token) {
        this.token = token;
    }
}
