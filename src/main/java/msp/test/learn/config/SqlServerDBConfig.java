package msp.test.learn.config;

import msp.test.learn.commons.InitConstants;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "msp.test.learn.repository.person",
        entityManagerFactoryRef = "sqlServerEntityManagerFactory",
        transactionManagerRef = "sqlServerTransactionManager")
@EnableTransactionManagement
public class SqlServerDBConfig {

    private final InitConstants initConstants;

    SqlServerDBConfig(InitConstants initConstants) {
        this.initConstants = initConstants;
    }

    @PostConstruct
    public void init() {
        initConstants.readConfigFile();
    }

    @Bean(name = "sqlServerDataSource")
    public DataSource getSqlServerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://192.168.1.143:1433;databaseName=Malavitestdata"); // e.g., jdbc:sqlserver://192.168.1.143:1433;databaseName=Malavitestdata
        dataSource.setUsername("sa"); // e.g., sa
        dataSource.setPassword("1234567"); // e.g., 1234567
        return dataSource;
    }

    @Bean(name = "sqlServerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getSqlServerEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getSqlServerDataSource()); // Ensure this method configures SQL Server DataSource
        emf.setPackagesToScan("msp.test.learn.entity.person"); // Package containing SQL Server entities

        // Set up Hibernate JPA properties
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);

        // Set the correct dialect for SQL Server
        Map<String, Object> jpaProperties = new HashMap<>();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "none"); // Adjust according to your strategy

        emf.setJpaPropertyMap(jpaProperties);

        return emf;
    }


    @Bean(name = "sqlServerTransactionManager")
    public PlatformTransactionManager getSqlServerTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getSqlServerEntityManagerFactory().getObject());
        return transactionManager;
    }
}
