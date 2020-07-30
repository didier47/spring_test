package com.demo.spring_test.models.repository;

import com.demo.spring_test.models.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductoRepository extends CrudRepository<ProductoEntity, UUID> {

}
