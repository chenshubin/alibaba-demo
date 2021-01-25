package cn.murphy.registcenter;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class RegistCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistCenterApplication.class, args);
    }

}
