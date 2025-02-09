package com.ganga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User3 {
    private Integer userId;
    private String name;
    private Integer age;
    private Userprofile2 profile;
}
