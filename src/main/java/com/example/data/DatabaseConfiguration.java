package com.example.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

//@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
      //  populator.addScript(new ClassPathResource("script.sql"));
        //populator.addScript(new ClassPathResource("data.sql"));
        initializer.setDatabasePopulator(populator);
        return initializer;
    }
}
