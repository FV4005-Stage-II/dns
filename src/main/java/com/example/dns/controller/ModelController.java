package com.example.dns.controller;



import com.example.dns.dto.DeviceDto;
import com.example.dns.dto.DeviceModelDto;
import com.example.dns.dto.ModelDto;
import com.example.dns.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @PostMapping(value = "/add-model", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Добавление новой модели", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(name = "Example", value =
                            "{" +
                                    "  \"manufacturerCountry\": \"Байкал\"," +
                                    "  \"manufacturerCompany\": \"Россия\"," +
                                    "  \"typeName\": \"пылесос\"," +
                                    "  \"name\": \"Модель X\"," +
                                    "  \"serialNumber\": \"123456789\"," +
                                    "  \"color\": \"Черный\"," +
                                    "  \"size\": \"XL\"," +
                                    "  \"price\": 100.50," +
                                    "  \"category\": \"бюджетный сегмент\"," +
                                    "  \"available\": true," +
                                    "  \"attributeDto\":" +
                                    "{" +
                                    "  \"technology\": \"Oled\"," +
                                    "  \"dustbinVolume\": \"2 литра\"," +
                                    "  \"numberOfModes\": 3," +
                                    "  \"numberOfDoors\": 4," +
                                    "  \"compressorType\": \"винтовой\"," +
                                    "  \"memory\": \"8 ГБ\"," +
                                    "  \"numberOfCamera\": 2," +
                                    "  \"processorType\": \"многоядерный\"" +
                                    "}" +
                                    "}")
            )
    ))
    public ResponseEntity<?> addModel(@Valid @RequestBody ModelDto modelDto) {
        modelService.addModel(modelDto);
        return new ResponseEntity<>(modelDto, HttpStatus.OK);
    }

    @PostMapping(value = "/add-full-model", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Добавление новой модели c техникой", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = "application/json",
            examples = @ExampleObject(name = "Example", value =
                    "{" +
                            "\"deviceDto\": {" +
                            "    \"manufacturerCompany\": \"Байкал\"," +
                            "    \"onlineOrderAvailable\": true," +
                            "    \"name\": \"Пылесос\"," +
                            "    \"installmentAvailable\": true," +
                            "    \"manufacturerCountry\": \"Россия\"" +
                            "}," +
                            "\"modelDto\": {" +
                            "    \"name\": \"Модель X\"," +
                            "    \"serialNumber\": \"123456789\"," +
                            "    \"color\": \"Черный\"," +
                            "    \"size\": \"XL\"," +
                            "    \"price\": 100.50," +
                            "    \"category\": \"бюджетный сегмент\"," +
                            "    \"available\": true," +
                            "    \"attributeDto\": {" +
                            "        \"technology\": \"Oled\"," +
                            "        \"dustbinVolume\": \"2 литра\"," +
                            "        \"numberOfModes\": 3," +
                            "        \"numberOfDoors\": 4," +
                            "        \"compressorType\": \"винтовой\"," +
                            "        \"memory\": \"8 ГБ\"," +
                            "        \"numberOfCamera\": 2," +
                            "        \"processorType\": \"многоядерный\"" +
                            "    }" +
                            "}" +
                    "}")
            )
    ))
    public ResponseEntity<?> addFullModel(@Valid @RequestBody DeviceModelDto deviceModelDto) {
        modelService.addFullModel(deviceModelDto.getModelDto(), deviceModelDto.getDeviceDto());
        return new ResponseEntity<>(deviceModelDto, HttpStatus.OK);
    }

}
