package com.example.dns.dto.factory;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.attributeType.*;
import com.example.dns.entity.AttributeValue;
import com.example.dns.entity.Model;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Locale;

import static com.example.dns.dto.factory.attributeType.DeviceTypeName.*;


@Slf4j
public class AttributeFactory { // исключение если нету типаа техники и enum
    public static List<AttributeValue> createAttribute(String type, AttributeDto attributeDto, Model device) {
        log.info("Фабрика в процессе создания");
        DeviceTypeName deviceTypeName = DeviceTypeName.fromName(type.toLowerCase());
        switch (deviceTypeName) {
            case TELEVISION:
                return new TelevisionAttributes().createAttributeValue(attributeDto, device);
            case VACUUM_CLEANER:
                return new VacumCleanerAttributes().createAttributeValue(attributeDto, device);
            case REFRIGERATOR:
                return new RefrigeratorAttributes().createAttributeValue(attributeDto, device);
            case SMARTPHONE:
                return new SmartphoneAttributes().createAttributeValue(attributeDto, device);
            case COMPUTER:
                return new ComputerAttributes().createAttributeValue(attributeDto, device);
            default:
                throw new IllegalArgumentException("Invalid device name: " + deviceTypeName.getName());
        }
    }
}
