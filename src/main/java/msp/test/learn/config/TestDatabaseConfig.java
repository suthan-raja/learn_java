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
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories( basePackages = "msp.test.learn.repository.*"
                        ,transactionManagerRef = "testDbTransactionManager"
                        ,entityManagerFactoryRef = "testDbEntityManager")
public class TestDatabaseConfig {

    private final InitConstants initConstants;

    public TestDatabaseConfig(InitConstants initConstants) {
        this.initConstants = initConstants;
    }

    @PostConstruct
    public void init() {
        initConstants.readConfigFile();
    }

    @Bean( name = "testDatasource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(InitConstants.testDbUrl);
        dataSource.setUsername(InitConstants.testDbUsername);
        dataSource.setPassword(InitConstants.testDbPassword);
        return dataSource;
    }

    @Bean( name = "testDbEntityManager")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPackagesToScan("msp.test.learn.entity");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(vendorAdapter);
        bean.setJpaPropertyMap(Map.of(
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect",
                "hibernate.hbm2ddl.auto", "update"
        ));

        return bean;
    }


    @Bean( name = "testDbTransactionManager")
    public PlatformTransactionManager getTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return transactionManager;
    }

}
