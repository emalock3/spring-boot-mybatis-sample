package com.github.emalock3.mybatis;

import com.github.emalock3.mybatis.service.FooBarService;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext cac = new SpringApplicationBuilder(Application.class).run(args);
        FooBarService service = cac.getBean(FooBarService.class);
        service.createTestData();
        service.printAllFooAndAllBar();
    }
    
    @Configuration
    @MapperScan(value="com.github.emalock3.mybatis.mapper.primary", 
            sqlSessionFactoryRef="sqlSessionFactoryForPrimary")
    static class MyBatisConfigurationForPrimary {
        
        @Primary
        @Bean
        @ConfigurationProperties(prefix="spring.datasource-primary")
        public DataSource primaryDataSource() {
            return DataSourceBuilder.create().build();
        }
        
        @Bean
        public JdbcTemplate primaryJdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(primaryDataSource());
            jdbcTemplate.execute("create table foo (id integer primary key, name varchar(64) not null)");
            return jdbcTemplate;
        }
        
        @Bean
        public SqlSessionFactory sqlSessionFactoryForPrimary() throws Exception {
            SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
            ssfb.setDataSource(primaryDataSource());
            return ssfb.getObject();
        }
    }
    
    @Configuration
    @MapperScan(value="com.github.emalock3.mybatis.mapper.secondary", 
            sqlSessionFactoryRef="sqlSessionFactoryForSecondary")
    static class MyBatisConfigurationForSecondary {
        
        @Bean
        @ConfigurationProperties(prefix="spring.datasource-secondary")
        public DataSource secondaryDataSource() {
            return DataSourceBuilder.create().build();
        }
        
        @Bean
        public JdbcTemplate secondaryJdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(secondaryDataSource());
            jdbcTemplate.execute("create table bar (id integer primary key, name varchar(64) not null)");
            return jdbcTemplate;
        }
        
        @Bean
        public SqlSessionFactory sqlSessionFactoryForSecondary() throws Exception {
            SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
            ssfb.setDataSource(secondaryDataSource());
            return ssfb.getObject();
        }
    }
}
