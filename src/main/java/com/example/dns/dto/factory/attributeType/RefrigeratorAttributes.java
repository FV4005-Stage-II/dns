package com.example.dns.dto.factory.attributeType;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.entity.AttributeValue;

import java.util.Arrays;
import java.util.List;

public class RefrigeratorAttributes  extends Attribute {
    @Override
    public List<AttributeValue> createAttributeValue(AttributeDto attributeDto) {
        return Arrays.asList(
                AttributeValue.builder()
                        .attribute("количество дверей")
                        .value(String.valueOf(attributeDto.getNumberOfDoors()))
                        .build(),
                AttributeValue.builder()
                        .attribute("тип компрессора")
                        .value(String.valueOf(attributeDto.getCompressorType()))
                        .build());
    }
}
