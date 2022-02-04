package com.example.car_tax_management.repositories;

import com.example.car_tax_management.entites.Owner;
import io.swagger.annotations.Api;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "owner", path = "owner")
public interface OwnerRepository extends PagingAndSortingRepository<Owner, Integer> {
}
