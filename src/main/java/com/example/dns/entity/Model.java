package com.example.dns.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@Table(name="model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private double price;
    private String category;
    private boolean available;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "device_id")
    private Device device;

    @JsonIgnore
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttributeValue> attributeValues;
}
