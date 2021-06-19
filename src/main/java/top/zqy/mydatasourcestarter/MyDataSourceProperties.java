package top.zqy.mydatasourcestarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyDataSourceProperties
 * @Author Elv1s
 * @Date 2021/6/19 13:36
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.datasource")
@Data
@Component
//@PropertySource("classpath:application.yml")
public class MyDataSourceProperties {

    public String username;
    public String password;
    public String url;
    public String driverClassName;
}
