package com.ganga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Userprofile {
    private Integer profileId;
    private Integer userId;
    private String firstName;
    private String lastName;
    private String gender;
}
