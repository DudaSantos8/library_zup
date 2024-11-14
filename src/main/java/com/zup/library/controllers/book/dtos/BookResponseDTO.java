package com.zup.library.controllers.book.dtos;

import com.zup.library.controllers.endUser.dtos.ConsumerResponseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookResponseDTO {

    private String id;
    private String title;
    private String description;
    private List<ConsumerResponseDTO> consumers = new ArrayList<>();
}
