package com.example.car_tax_management.repositories;

import com.example.car_tax_management.entites.TaxInfo;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api(tags = "Address Entity")
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "taxinfo", path = "taxinfo")
public interface TaxInfoRepository extends PagingAndSortingRepository<TaxInfo, Integer> {
}
