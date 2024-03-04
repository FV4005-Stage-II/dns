package com.example.dns.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "сущность модели")
@Data
public class ModelDto {

    @Schema(description = "Страна производителя", example = "Россия", required = true)
    @NotBlank(message = "manufacturerCountry не должно быть пустым полем")
    private String manufacturerCountry;

    @Schema(description = "Страна компании", example = "Байкал", required = true)
    @NotBlank(message = "manufacturerCompany не должно быть пустым полем")
    private String manufacturerCompany;

    @Schema(description = "Название теники", example = "Модель X", required = true)
    @NotBlank(message = "typeName не должно быть пустым полем")
    private String typeName;

    @Schema(description = "Название модели", example = "Модель X", required = true)
    @NotBlank(message = "name не должно быть пустым полем")
    private String name;

    @Schema(description = "Серийный номер модели", example = "123456789", required = true)
    @NotBlank(message = "serialNumber не должно быть пустым полем")
    private String serialNumber;

    @Schema(description = "Цвет модели", example = "Черный", required = true)
    @NotBlank(message = "color не должно быть пустым полем")
    private String color;

    @Schema(description = "Размер модели", example = "XL", required = true)
    @NotBlank(message = "size не должно быть пустым полем")
    private String size;

    @Schema(description = "Цена модели", example = "100.50", required = true)
    @NotNull(message = "price не должно быть пустым полем")
    @Min(value = 1, message = "price должно быть не меньше 1")
    @Max(value = Long.MAX_VALUE)
    private double price;

    @Schema(description = "Категория модели", example = "бюджетный сегмент", required = true)
    @NotBlank(message = "category не должно быть пустым полем")
    private String category;

    @Schema(description = "Доступность модели", example = "true", required = true)
    @NotNull(message = "available не должно быть пустым полем")
    private boolean available;

    @Schema(description = "Дополнительные атрибуты в формате JSON")
    @NotNull(message = "attributeDto не должно быть пустым полем")
    @Valid
    private AttributeDto attributeDto;
}
