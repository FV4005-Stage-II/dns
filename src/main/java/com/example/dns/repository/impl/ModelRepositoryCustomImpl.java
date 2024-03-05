package com.example.dns.repository.impl;


import com.example.dns.dto.ModelDto;
import com.example.dns.entity.Model;
import com.example.dns.repository.ModelRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class ModelRepositoryCustomImpl implements ModelRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public ModelRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Model> findModelsByCriteria(ModelDto modelDto) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Model> query = criteriaBuilder.createQuery(Model.class);
        Root<Model> root = query.from(Model.class);

        Predicate predicate = criteriaBuilder.conjunction();
        if (modelDto != null) {
            if (modelDto.getManufacturerCountry() != null && !modelDto.getManufacturerCountry().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("manufacturerCountry"), modelDto.getManufacturerCountry()));
            }
            if (modelDto.getManufacturerCompany() != null && !modelDto.getManufacturerCompany().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("manufacturerCompany"), modelDto.getManufacturerCompany()));
            }
            if (modelDto.getTypeName() != null && !modelDto.getTypeName().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("typeName"), modelDto.getTypeName()));
            }
        }

        query.select(root).where(predicate);
        return entityManager.createQuery(query).getResultList();
    }
}