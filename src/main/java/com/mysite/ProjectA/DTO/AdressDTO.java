package com.mysite.ProjectA.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

}
