package com.zup.library.controllers.endUser.dtos;

import com.zup.library.models.Role;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class ConsumerUpdateDTO {

    @Size(min = 3, message = "field not valid")
    private String username;

    @Size(min = 3, message = "field not valid")
    private String lastName;

    @Min(value = 1950)
    private int yearOfBirth;

    private int yearOfDeath;

    @NotEmpty(message = "field can't be empty")
    private String password;

    private Set<Role> roles;
}