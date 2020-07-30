package com.demo.spring_test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Autowired
    private CassandraProperties cassandraProperties;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected String getKeyspaceName() {
        return cassandraProperties.getKeyspaceName();
    }

    @Override
    protected String getLocalDataCenter() {
        return cassandraProperties.getLocalDatacenter();
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{applicationContext.getBeansWithAnnotation(SpringBootApplication.class)
                .values()
                .iterator()
                .next()
                .getClass()
                .getPackage()
                .getName()};
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(cassandraProperties.getKeyspaceName())
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withNetworkReplication(DataCenterReplication.of("datacenter1", 1))
                .ifNotExists();

        return Arrays.asList(specification);
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(cassandraProperties.getKeyspaceName()));
    }

}
