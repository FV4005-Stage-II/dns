package com.example.dns.dto.factory.attributeType;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.entity.AttributeValue;

import java.util.Arrays;
import java.util.List;

public class TelevisionAttributes  extends Attribute {
    @Override
    public List<AttributeValue> createAttributeValue(AttributeDto attributeDto) {
        return Arrays.asList(
                AttributeValue.builder()
                        .attribute("технология")
                        .value(attributeDto.getTechnology())
                        .build());
    }
}