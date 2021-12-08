package com.example.demo.info.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DataSourceConfiguration {

	@Bean(name="customDataSource")
	@ConfigurationProperties("spring.datasource")
	public DataSource DataSourceConfiguration() {
		return DataSourceBuilder.create().build();
	}
	
}
