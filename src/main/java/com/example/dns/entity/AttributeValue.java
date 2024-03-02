package com.example.dns.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name="attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attribute;
    private String value;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private Model model;

}
