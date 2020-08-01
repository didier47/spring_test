package com.demo.spring_test.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(value = "producto")
public class ProductoEntity implements Serializable {

    @PrimaryKey
    private UUID id;

    @Column("nombre")
    private String nombre;

    @Column("precio")
    private Double precio;

    @Column("created_at")
    private LocalDateTime createdAt;

}
