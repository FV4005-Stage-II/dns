package com.example.dns.service;


import com.example.dns.dto.ModelDto;
import com.example.dns.dto.factory.Attribute;
import com.example.dns.dto.factory.AttributeFactory;
import com.example.dns.entity.AttributeValue;
import com.example.dns.entity.Device;
import com.example.dns.entity.Model;
import com.example.dns.repository.AttributeValueRepository;
import com.example.dns.repository.DeviceRepository;
import com.example.dns.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;
    private final DeviceRepository deviceRepository;
    private final AttributeValueRepository attributeValueRepository;
    @Transactional
    public void addModel(ModelDto modelDto) {
        Device device = deviceRepository.
                findFirstByCountryAndCompanyAndName(
                        modelDto.getManufacturerCountry(),
                        modelDto.getManufacturerCompany(),
                        modelDto.getTypeName()).get(0);

        modelRepository.save(Model.builder().
                name(modelDto.getName()).
                serialNumber(modelDto.getSerialNumber()).
                color(modelDto.getColor()).
                size(modelDto.getSize()).
                price(modelDto.getPrice()).
                category(modelDto.getCategory()).
                available(modelDto.isAvailable()).
                device(device).
                attributeValues(new ArrayList<>()).
                build());


        attributeValueRepository.saveAll(
                AttributeFactory.createAttribute(device.getName(),
                        modelDto.getAttributeDto(), modelRepository.findByName(modelDto.getName())));


    }


}
