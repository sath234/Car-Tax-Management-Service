package com.example.car_tax_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
public class CarTaxManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarTaxManagementApplication.class, args);
    }

}
