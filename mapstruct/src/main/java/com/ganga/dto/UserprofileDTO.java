package com.ganga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserprofileDTO {
    private Integer profileId;
    private Integer userId;
    private String firstName;
    private String lastName;
    private String gender;
}
