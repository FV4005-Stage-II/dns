package com.example.dns.dto;

import lombok.Data;

import javax.validation.Valid;

@Data
public class DeviceModelDto {
    @Valid
    private DeviceDto deviceDto;
    @Valid
    private ModelDto modelDto;
}
