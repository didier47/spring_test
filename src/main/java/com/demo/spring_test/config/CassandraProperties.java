package com.demo.spring_test.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@Validated
@ConfigurationProperties("spring.data.cassandra")
public class CassandraProperties {

    private String keyspaceName;
    private String contactPoints;
    private int port;
    private String localDatacenter;

}
