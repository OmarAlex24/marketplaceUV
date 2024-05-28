package com.omar.restapicrud.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostDTO {

    private String title;
    private String description;
    private Long articlePrice;
    private Long categoryId;
    private Integer quantity;
    private Long ownerId;

}
