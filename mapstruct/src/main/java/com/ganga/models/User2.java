package com.ganga.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2 {
    private Integer userId;
    private String name;
    private Integer age;
    private Userprofile profile;
}
