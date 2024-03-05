package com.example.dns.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class DeviceModelDto {
    @Valid
    private DeviceDto deviceDto;
    @Valid
    private ModelDto modelDto;


    @Min(value = 1, message = "maxPrice должно быть не меньше 1")
    @Max(value = Long.MAX_VALUE)
    private double maxPrice;

    @Min(value = 1, message = "minPrice должно быть не меньше 1")
    @Max(value = Long.MAX_VALUE)
    private double minPrice;
}
