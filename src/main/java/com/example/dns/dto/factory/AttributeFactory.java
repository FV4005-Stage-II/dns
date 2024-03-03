package com.example.dns.dto.factory;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.DeviceDto;
import com.example.dns.dto.factory.attributeType.*;
import com.example.dns.entity.AttributeValue;
import com.example.dns.entity.Device;
import com.example.dns.entity.Model;

import java.lang.reflect.Field;
import java.util.List;


public class AttributeFactory {
    public static List<AttributeValue> createAttribute(String type, AttributeDto attributeDto, Model device) {
        switch(type) {
            case "телевизор":
                return new TelevisionAttributes().createAttributeValue(attributeDto, device);
            case "пылесос":
                return new VacumCleanerAttributes().createAttributeValue(attributeDto, device);
            case "холодильник":
                return new RefrigeratorAttributes().createAttributeValue(attributeDto, device);
            case "смартфон":
                return new SmartphoneAttributes().createAttributeValue(attributeDto, device);
            case "компьютер":
                return new ComputerAttributes().createAttributeValue(attributeDto, device);
            default:
                return null;
        }
    }
}
