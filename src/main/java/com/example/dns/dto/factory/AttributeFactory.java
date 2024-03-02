package com.example.dns.dto.factory;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.DeviceDto;
import com.example.dns.dto.factory.attributeType.*;
import com.example.dns.entity.AttributeValue;

import java.lang.reflect.Field;
import java.util.List;


public class AttributeFactory {
    public static List<AttributeValue> createAttribute(String type, AttributeDto attributeDto) {
        switch(type) {
            case "телевизор":
                return new TelevisionAttributes().createAttributeValue(attributeDto);
            case "пылесос":
                return new VacumCleanerAttributes().createAttributeValue(attributeDto);
            case "холодильник":
                return new RefrigeratorAttributes().createAttributeValue(attributeDto);
            case "смартфон":
                return new SmartphoneAttributes().createAttributeValue(attributeDto);
            case "компьютер":
                return new ComputerAttributes().createAttributeValue(attributeDto);
            default:
                return null;
        }
    }
}
