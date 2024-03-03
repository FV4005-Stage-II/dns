package com.example.dns.repository;

import com.example.dns.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("SELECT d FROM Device d" +
            " WHERE LOWER(d.manufacturerCountry) = LOWER(:manufacturerCountry) " +
            "AND LOWER(d.manufacturerCompany) = LOWER(:manufacturerCompany) " +
            "AND LOWER(d.name) = LOWER(:name) ")
    List<Device> findFirstByCountryAndCompanyAndName(
            @Param("manufacturerCountry") String manufacturerCountry,
            @Param("manufacturerCompany") String manufacturerCompany,
            @Param("name") String name);

}
