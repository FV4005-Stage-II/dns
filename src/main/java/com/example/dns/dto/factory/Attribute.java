package com.example.dns.dto.factory;

import com.example.dns.dto.AttributeDto;
import com.example.dns.entity.AttributeValue;

import java.util.List;

public abstract class Attribute {
    List<AttributeValue> attributeValues;

    public abstract List<AttributeValue> createAttributeValue(AttributeDto attributeDto);
}
