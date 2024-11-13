package com.zup.library.controllers.endUser.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class EndUserUpdateDTO {

    @Size(min = 3, message = "field not valid")
    private String name;

    @Size(min = 3, message = "field not valid")
    private String lastName;

    @Min(value = 1950)
    private int yearOfBirth;

    private int yearOfDeath;

    public EndUserUpdateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }
}