package com.jsc.config;//package com.jsc.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.pool.DruidDataSourceFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ContextConfiguration;
//
//import javax.sql.DataSource;
//
//
//@Component
//@PropertySource("classPath:druid.properties")
//public class Config {
//    @Value("${driverClassName}")
//    private String driverClassName;
//    @Value("${url}")
//    private String url;
//    @Value("${username}")
//    private String username;
//    @Value("${password}")
//    private String password;
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean("datasource")
//    public DataSource getDs(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(this.driverClassName);
//        druidDataSource.setUrl(this.url);
//        druidDataSource.setUsername(this.username);
//        druidDataSource.setPassword(this.password);
//        return druidDataSource;
//    }
//
//    @Bean("JdbcTemplate")
//    public JdbcTemplate getJdbcTemplate(){
//        return new JdbcTemplate(this.dataSource);
//    }
//}
