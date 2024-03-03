package com.example.dns.dto.factory.attributeType;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.entity.AttributeValue;
import com.example.dns.entity.Model;

import java.util.Arrays;
import java.util.List;

public class TelevisionAttributes extends Attribute {
    @Override
    public List<AttributeValue> createAttributeValue(AttributeDto attributeDto, Model model) {
        return Arrays.asList(
                AttributeValue.builder()
                        .attribute("технология")
                        .value(attributeDto.getTechnology())
                        .model(model)
                        .build());
    }
}