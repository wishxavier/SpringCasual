package org.wish.spring.democonfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.wish.spring.democonfiguration.model.LegoItem;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigurationApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "lego")
    LegoItem defaultLegoItem() {
        return new LegoItem();
    }
}
