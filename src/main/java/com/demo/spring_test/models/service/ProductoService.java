package com.demo.spring_test.models.service;

import com.demo.spring_test.models.entity.ProductoEntity;

import java.util.List;
import java.util.UUID;

public interface ProductoService {

    List<ProductoEntity> findAll();

    ProductoEntity findById(UUID id);

}
