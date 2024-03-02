package com.example.dns.service;


import com.example.dns.dto.DeviceDto;
import com.example.dns.entity.AttributeValue;
import com.example.dns.entity.Device;
import com.example.dns.repository.AttributeValueRepository;
import com.example.dns.repository.DeviceRepository;
import com.example.dns.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Null;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final ModelRepository modelRepository;
    private final AttributeValueRepository attributeValueRepository;


    public void addDevice(DeviceDto deviceDto) {
        deviceRepository.save(Device.builder().name(deviceDto.getName())
                .manufacturerCompany(deviceDto.getManufacturerCompany())
                .manufacturerCountry(deviceDto.getManufacturerCountry())
                .onlineOrderAvailable(deviceDto.isOnlineOrderAvailable())
                .installmentAvailable(deviceDto.isInstallmentAvailable())
                .models(new ArrayList<>())
                .build());
    }


}
