package com.zup.library.controllers.endUser.dtos;

import lombok.Data;

@Data
public class ConsumerResponseDTO {

    private String id;
    private String username;
    private String lastName;
    private int yearOfBirth;
    private int yearOfDeath;
}
