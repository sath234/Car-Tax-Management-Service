package com.example.car_tax_management.configuration;

import com.example.car_tax_management.entites.*;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Address.class);
        config.exposeIdsFor(Owner.class);
        config.exposeIdsFor(Car.class);
        config.exposeIdsFor(TaxInfo.class);
        config.exposeIdsFor(Sorn.class);
        config.exposeIdsFor(TaxPayment.class);
    }
}
