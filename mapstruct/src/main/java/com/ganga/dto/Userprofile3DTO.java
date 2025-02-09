package com.ganga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userprofile3DTO {
    private String fName;
    private String lName;
    private String gender;
    private Boolean isActive = true;
}
