package com.example.dns.service;


import com.example.dns.dto.DeviceDto;
import com.example.dns.dto.DeviceModelDto;
import com.example.dns.dto.DeviceModelForFilter;
import com.example.dns.dto.ModelDto;
import com.example.dns.dto.factory.AttributeFactory;
import com.example.dns.entity.Device;
import com.example.dns.entity.Model;
import com.example.dns.repository.AttributeValueRepository;
import com.example.dns.repository.DeviceRepository;
import com.example.dns.repository.ModelRepository;
import com.example.dns.repository.ModelRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;
    private final DeviceRepository deviceRepository;
    private final AttributeValueRepository attributeValueRepository;
    private final ModelRepositoryCustom modelRepositoryCustom;

    private final DeviceService deviceService;


    public void addModel(ModelDto modelDto) {
        Device device = deviceRepository.
                findFirstByCountryAndCompanyAndName(
                        modelDto.getManufacturerCountry(),
                        modelDto.getManufacturerCompany(),
                        modelDto.getTypeName()).get(0);
        log.info("Получение техники");

        attributeValueRepository.saveAll(
                AttributeFactory.createAttribute(device.getName(),
                        modelDto.getAttributeDto(),
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
                                build())));
        log.info("Сохранение модели");
        log.info("Сохранение атрибутов");
        // select * from device join model on device.id = model.device_id join attribute_value on attribute_value.model_id = model.id;
    }

    public void addFullModel(ModelDto modelDto, DeviceDto deviceDto) {
        Device device = deviceService.addDevice(deviceDto);
        log.info("Получение и сохранение техники");

        attributeValueRepository.saveAll(
                AttributeFactory.createAttribute(device.getName(),
                        modelDto.getAttributeDto(),
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
                                build())));
        log.info("Сохранение модели");
        log.info("Сохранение атрибутов");
        // select * from device join model on device.id = model.device_id join attribute_value on attribute_value.model_id = model.id;
    }

    public List<Model> getAllModelsByCrytery(DeviceModelForFilter deviceModelForFilter) {
        return modelRepository.findModelsByCriteria(
                deviceModelForFilter.getName(),
                deviceModelForFilter.getSerialNumber(),
                deviceModelForFilter.getColor(),
                deviceModelForFilter.getSize(),
                deviceModelForFilter.getCategory(),
                deviceModelForFilter.isAvailable(),
                deviceModelForFilter.getTypeName(),
                deviceModelForFilter.getManufacturerCountry(),
                deviceModelForFilter.getManufacturerCompany(),
                deviceModelForFilter.isOnlineOrderAvailable(),
                deviceModelForFilter.isInstallmentAvailable(),
                deviceModelForFilter.getMinPrice(),
                deviceModelForFilter.getMaxPrice()
        );
    }

//    {
//        "manufacturerCountry": "Россия",
//            "manufacturerCompany": "Байкал",
//            "onlineOrderAvailable": null,
//            "installmentAvailable": null,
//            "typeName": "Пылесос",
//            "name": "Модель X",
//            "serialNumber": null,
//            "color": "Черный",
//            "size": "XL",
//            "category": "бюджетный сегмент",
//            "available": true,
//            "maxPrice": 1000,
//            "minPrice": 10
//    }

//    public List<Model> getAllModels() {
//        return modelRepository.findAllModelsByPriceRange(10,200);
//    }
//
//    public List<Model> getAllModelsCustom(ModelDto modelDto) {
//        return modelRepositoryCustom.findModelsByCriteria();
//    }
}
