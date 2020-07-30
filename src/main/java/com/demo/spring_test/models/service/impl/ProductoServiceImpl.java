package com.demo.spring_test.models.service.impl;

import com.demo.spring_test.models.entity.ProductoEntity;
import com.demo.spring_test.models.repository.ProductoRepository;
import com.demo.spring_test.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoEntity> findAll() {
        return (List<ProductoEntity>) productoRepository.findAll();
    }

    @Override
    public ProductoEntity findById(UUID id) {
        return productoRepository.findById(id).orElse(null);
    }
}
