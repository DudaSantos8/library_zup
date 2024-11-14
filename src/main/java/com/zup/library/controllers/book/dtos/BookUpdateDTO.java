package com.zup.library.controllers.book.dtos;

import com.zup.library.models.Consumers;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BookUpdateDTO {

    @Size(min = 3, message = "title not valid")
    private String title;

    @NotNull(message = "this field can't be null")
    private String description;

    @Size(max = 5, message = "this book can't have more than  five authors")
    private Set<Consumers> consumers = new HashSet<>();
}
