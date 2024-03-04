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

}
