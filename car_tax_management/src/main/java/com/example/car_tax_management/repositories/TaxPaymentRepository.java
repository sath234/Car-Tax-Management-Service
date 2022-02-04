package com.example.car_tax_management.repositories;

import com.example.car_tax_management.entites.TaxPayment;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api(tags = "Address Entity")
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "taxpayment", path = "taxpayment")
public interface TaxPaymentRepository extends PagingAndSortingRepository<TaxPayment, Integer> {
}
