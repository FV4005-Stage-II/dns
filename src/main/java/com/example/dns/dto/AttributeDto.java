package com.example.dns.dto;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AttributeDto {

    @NotBlank(message = "technology не должно быть пустым полем")
    private String technology;
    @NotBlank(message = "dustbinVolume не должно быть пустым полем")
    private String dustbinVolume;

    @NotNull(message = "numberOfModes не должно быть пустым полем")
    @Min(value = 1, message = "numberOfModes должно быть не меньше 1")
    @Max(value = Long.MAX_VALUE)
    private int numberOfModes;

    @NotNull(message = "numberOfDoors не должно быть пустым полем")
    @Min(value = 1, message = "numberOfDoors должно быть не меньше 1")
    @Max(value = 50, message = "numberOfDoors должно быть не больше 50")
    private int numberOfDoors;

    @NotBlank(message = "compressorType не должно быть пустым полем")
    private String compressorType;
    @NotBlank(message = "memory не должно быть пустым полем")
    private String memory;

    @NotNull(message = "numberOfCamera не должно быть пустым полем")
    @Min(value = 1, message = "numberOfCamera должно быть не меньше 1")
    @Max(value = 50)
    private int numberOfCamera;

    @NotBlank(message = "manufacturerCompany не должно быть пустым полем")
    private String processorType;
}
