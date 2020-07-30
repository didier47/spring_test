package com.demo.spring_test.controllers;

import com.demo.spring_test.models.entity.ProductoEntity;
import com.demo.spring_test.models.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = "/producto")
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public List<ProductoEntity> findAll() {
        return productoService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ProductoEntity findById(@PathVariable UUID id) {
        return productoService.findById(id);
    }

}
