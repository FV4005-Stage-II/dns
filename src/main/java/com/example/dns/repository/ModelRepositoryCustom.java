package com.example.dns.repository;
import com.example.dns.dto.ModelDto;
import com.example.dns.entity.Model;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ModelRepositoryCustom {
    List<Model> findModelsByCriteria(ModelDto modelDto);

}
