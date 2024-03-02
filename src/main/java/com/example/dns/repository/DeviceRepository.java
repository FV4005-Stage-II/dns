package com.example.dns.repository;

import com.example.dns.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query("SELECT d FROM Device d WHERE d.manufacturerCountry = :manufacturerCountry AND d.manufacturerCompany = :manufacturerCompany AND d.name = :name")
    Device findByCountryAndCompanyAndName(String manufacturerCountry, String manufacturerCompany, String name);
}
