package com.example.inflearnjpa1.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class MemberForm {

    @NotBlank
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
