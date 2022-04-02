package com.study.cucumberresttests.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private String city;
    private String state;
    private String country;
    private String pincode;
}