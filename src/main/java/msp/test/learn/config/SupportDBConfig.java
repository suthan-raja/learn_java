package msp.test.learn.config;

import msp.test.learn.commons.InitConstants;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "msp.test.learn.repository.support"
                        ,entityManagerFactoryRef = "supportEntityManagerFac"
                        ,transactionManagerRef = "supportTransactionManager")
public class SupportDBConfig {


    private final InitConstants initConstants;

    SupportDBConfig(InitConstants initConstants){
        this.initConstants = initConstants;
    }

    @PostConstruct
    public void init(){
        initConstants.readConfigFile();
    }

    @Bean(name = "supportDatasource")
    public DataSource getSupportDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(InitConstants.supportDBUrl);
        dataSource.setUsername(InitConstants.supportDBUsername);
        dataSource.setPassword(InitConstants.supportDBPassword);
        return dataSource;
    }

    @Bean(name = "supportEntityManagerFac")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getSupportDataSource());
        emf.setPackagesToScan("msp.test.learn.entity.support");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaPropertyMap(Map.of(
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect",
                "hibernate.hbm2ddl.auto", "update"));

        return emf;
    }

    @Bean(name = "supportTransactionManager")
    public PlatformTransactionManager getSupportTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
        return transactionManager;
    }


}
