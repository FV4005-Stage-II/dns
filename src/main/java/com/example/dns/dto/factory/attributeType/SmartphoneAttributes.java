package com.example.dns.dto.factory.attributeType;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.entity.AttributeValue;

import java.util.Arrays;
import java.util.List;

public class SmartphoneAttributes  extends Attribute {
    @Override
    public List<AttributeValue> createAttributeValue(AttributeDto attributeDto) {
        return Arrays.asList(
                AttributeValue.builder()
                        .attribute("память")
                        .value(attributeDto.getMemory())
                        .build(),
                AttributeValue.builder()
                        .attribute("количество камер")
                        .value(String.valueOf(attributeDto.getNumberOfCamera()))
                        .build());
    }
}
