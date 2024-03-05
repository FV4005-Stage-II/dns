package com.example.dns.repository;

import com.example.dns.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findByName(String name);
    Model findBySerialNumber(String serialNumber);

    @Query("SELECT m FROM Model m " +
            "JOIN m.device d " +
            "JOIN m.attributeValues av " +
            "WHERE d.id = m.device.id AND av.model.id = m.id" +
            "")
    List<Model> findAllModels();


    @Query("SELECT m FROM Model m " +
            "JOIN m.device d " +
            "JOIN m.attributeValues av " +
            "WHERE d.id = m.device.id AND av.model.id = m.id " +
            "AND m.price BETWEEN :minPrice AND :maxPrice" +
            "")
    List<Model> findAllModelsByPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);


    @Query("SELECT m FROM Model m " +
            "JOIN m.device d " +
            "JOIN m.attributeValues av " +
            "WHERE d.id = m.device.id AND av.model.id = m.id " +

            "AND (:name IS NULL OR m.name = :name) " +
            "AND (:serialNumber IS NULL OR m.serialNumber = :serialNumber) " +
            "AND (:color IS NULL OR m.color = :color) " +
            "AND (:size IS NULL OR m.size = :size) " +
            "AND (m.price BETWEEN :minPrice AND :maxPrice) " +
            "AND (:category IS NULL OR m.category = :category) " +
            "AND (:available IS NOT TRUE OR m.available = :available) "+

            "AND (d.name = :nameType OR :nameType IS NULL) " +
            "AND (d.manufacturerCountry = :manufacturerCountry OR :manufacturerCountry IS NULL) " +
            "AND (d.manufacturerCompany = :manufacturerCompany OR :manufacturerCompany IS NULL) " +
            "AND (d.onlineOrderAvailable = :onlineOrderAvailable OR :onlineOrderAvailable IS NOT TRUE) " +
            "AND (d.installmentAvailable = :installmentAvailable OR :installmentAvailable IS NOT TRUE)")
    List<Model> findModelsByCriteria(
            @Param("name") String name,
            @Param("serialNumber") String serialNumber,
            @Param("color") String color,
            @Param("size") String size,
            @Param("category") String category,
            @Param("available") Boolean available,

            @Param("nameType") String nameType,
            @Param("manufacturerCountry") String manufacturerCountry,
            @Param("manufacturerCompany") String manufacturerCompany,
            @Param("onlineOrderAvailable") Boolean onlineOrderAvailable,
            @Param("installmentAvailable") Boolean installmentAvailable,

            @Param("minPrice") double minPrice,
            @Param("maxPrice") double maxPrice
    );


}
