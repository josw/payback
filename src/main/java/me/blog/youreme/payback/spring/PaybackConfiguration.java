package me.blog.youreme.payback.spring;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * User: youreme
 * Date: 13. 10. 1.
 * Time: 오후 9:16
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:properties/jdbc.properties", "classpath:properties/common.properties"})
@EnableJpaRepositories("me.blog.youreme.payback.repository")
@ComponentScan(basePackages = { "me.blog.youreme.payback" } , excludeFilters = {@ComponentScan.Filter(Configuration.class), @ComponentScan.Filter(Controller.class)})
@EnableAspectJAutoProxy
public class PaybackConfiguration {
    @Inject
    Environment environment;

    /**
     * Multipart resolver.
     *
     * @return the standard servlet multipart resolver
     */
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    /**
     * datasource 설정
     * ticket 을 제외한 모든 data 사용 용도
     * bonecp 사용 (http://jolbox.com/) The fast Java JDBC Connection Pool
     *
     * @return data source
     */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        return dataSource;
    }

    /**
     * jpa 설정
     *
     * @return jpa transaction manager
     * @throws ClassNotFoundException the class not found exception
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return transactionManager;
    }

    /**
     *
     * jpa - hibernate 설정
     *
     * @return local container entity manager factory bean
     * @throws ClassNotFoundException the class not found exception
     */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("me.blog.youreme.payback.model");
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

        Properties jpaProterties = new Properties();
        jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//        jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQLMyISAMDialect");
        jpaProterties.put("hibernate.format_sql", true);
        jpaProterties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        jpaProterties.put("hibernate.show_sql", true);

        entityManagerFactoryBean.setJpaProperties(jpaProterties);

        return entityManagerFactoryBean;
    }

    // Hibernate를 이용하는 경우, 반드시 HibernateExceptionTranslator가 Bean에 등록되어야지 된다.
    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

    /**
     *
     * config property 설정
     *
     * @return property sources placeholder configurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configHolder = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[] { new ClassPathResource("properties/jdbc.properties"), new ClassPathResource("properties/common.properties") };
        configHolder.setLocations(resources);
        configHolder.setIgnoreUnresolvablePlaceholders(true);
        return configHolder;
    }

}
