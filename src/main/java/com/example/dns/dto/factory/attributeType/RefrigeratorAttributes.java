package com.example.dns.dto.factory.attributeType;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.entity.AttributeValue;
import com.example.dns.entity.Model;

import java.util.Arrays;
import java.util.List;

public class RefrigeratorAttributes  extends Attribute {
    @Override
    public List<AttributeValue> createAttributeValue(AttributeDto attributeDto, Model model) {
        return Arrays.asList(
                AttributeValue.builder()
                        .attribute("количество дверей")
                        .value(String.valueOf(attributeDto.getNumberOfDoors()))
                        .model(model)
                        .build(),
                AttributeValue.builder()
                        .attribute("тип компрессора")
                        .value(String.valueOf(attributeDto.getCompressorType()))
                        .model(model)
                        .build());
    }
}
