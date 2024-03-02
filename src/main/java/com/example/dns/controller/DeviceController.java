package com.example.dns.controller;


import com.example.dns.dto.DeviceDto;
import com.example.dns.service.DeviceService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;


    @PostMapping("/add-device")
    @Operation(summary = "Добавление новой техники", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Example", value = "{\"manufacturerCompany\":\"String\"," +
                                                                        "\"onlineOrderAvailable\":true," +
                                                                        "\"name\":\"String\"," +
                                                                        "\"installmentAvailable\":true," +
                                                                        "\"manufacturerCountry\":\"String\"}")
            )
    ))
    public ResponseEntity<?> addDevice(@RequestBody DeviceDto deviceDto) {
        deviceService.addDevice(deviceDto);
        return new ResponseEntity<>(deviceDto, HttpStatus.OK);
    }

}
