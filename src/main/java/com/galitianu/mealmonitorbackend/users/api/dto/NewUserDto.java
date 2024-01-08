package com.galitianu.mealmonitorbackend.users.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean gender;
}
