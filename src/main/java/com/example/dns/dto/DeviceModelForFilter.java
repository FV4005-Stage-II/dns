package com.example.dns.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class DeviceModelForFilter {

    private String typeName;
    private String manufacturerCountry;
    private String manufacturerCompany;
    private boolean onlineOrderAvailable;
    private boolean installmentAvailable;

    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private double price;
    private String category;
    private boolean available;

    private double minPrice;
    private double maxPrice;

}
