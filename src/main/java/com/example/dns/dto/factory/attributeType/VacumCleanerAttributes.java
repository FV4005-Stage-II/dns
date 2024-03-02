package com.example.dns.dto.factory.attributeType;

import com.example.dns.dto.AttributeDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.entity.AttributeValue;
import com.example.dns.repository.AttributeValueRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class VacumCleanerAttributes extends Attribute {
    @Override
    public List<AttributeValue> createAttributeValue(AttributeDto attributeDto) {
        return Arrays.asList(
                AttributeValue.builder()
                        .attribute("объем пылесборника")
                        .value(attributeDto.getDustbinVolume())
                        .build(),
                AttributeValue.builder()
                        .attribute("количество режимов")
                        .value(String.valueOf(attributeDto.getNumberOfModes()))
                        .build());
    }
}
