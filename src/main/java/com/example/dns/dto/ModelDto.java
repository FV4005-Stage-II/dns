package com.example.dns.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "сущность модели")
@Data
public class ModelDto {

    @Schema(description = "Страна производителя", example = "Россия", required = true)
    private String manufacturerCountry;

    @Schema(description = "Страна компании", example = "Байкал", required = true)
    private String manufacturerCompany;

    @Schema(description = "Название теники", example = "Модель X", required = true)
    private String typeName;

    @Schema(description = "Название модели", example = "Модель X", required = true)
    private String name;

    @Schema(description = "Серийный номер модели", example = "123456789", required = true)
    private String serialNumber;

    @Schema(description = "Цвет модели", example = "Черный", required = true)
    private String color;

    @Schema(description = "Размер модели", example = "XL", required = true)
    private String size;

    @Schema(description = "Цена модели", example = "100.50", required = true)
    private double price;

    @Schema(description = "Категория модели", example = "бюджетный сегмент", required = true)
    private String category;

    @Schema(description = "Доступность модели", example = "true", required = true)
    private boolean available;

    @Schema(description = "Дополнительные атрибуты в формате JSON")
    private AttributeDto attributeDto;
}
