package com.omar.restapicrud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String name;
    private String lastName;
    private String carnetNumber;
    private String password;
    private Long campusId;
    private String clabe;

}
