package top.zqy.mydatasourcestarter;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName MyDataSourceAutoConfiguration
 * @Author Elv1s
 * @Date 2021/6/19 14:54
 * @Description:
 */
@EnableConfigurationProperties(MyDataSourceProperties.class)
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "top.zqy.mydatasourcestarter.dao")
@ConditionalOnProperty(prefix = "my-data-source", name = "enable", havingValue = "true")
public class MyDataSourceAutoConfiguration {

    @Autowired
    MyDataSourceProperties myDataSourceProperties;
    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(myDataSourceProperties.getUsername());
        dataSource.setPassword(myDataSourceProperties.getPassword());
        dataSource.setUrl(myDataSourceProperties.getUrl());
        dataSource.setDriverClassName(myDataSourceProperties.getDriverClassName());
        return dataSource;
    }
}
