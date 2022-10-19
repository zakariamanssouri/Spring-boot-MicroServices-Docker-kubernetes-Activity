package me.zakaria.customermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;
}
