package com.repairService.repairService.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan
public class AppContext {

    private DBConfig dbConfig = new DBConfig();

    @Bean(name = "jdbcApplication")
    public DataSource dataSource2() {
        return dbConfig.getDataSource();
    }

    @Bean(name = "jdbcTemplateApplication")
    public JdbcTemplate jdbcTemplate2(@Qualifier("jdbcApplication") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}