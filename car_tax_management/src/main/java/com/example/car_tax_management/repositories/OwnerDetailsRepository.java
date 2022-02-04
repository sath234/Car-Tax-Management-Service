package com.example.car_tax_management.repositories;

import com.example.car_tax_management.entites.OwnerDTO;
import com.example.car_tax_management.entites.TaxDTO;
import com.example.car_tax_management.services.OwnerDTOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Owner Details Entity")
@RestController
@CrossOrigin
public class OwnerDetailsRepository {

    @Autowired
    private OwnerDTOService ownerDTOService;

    @GetMapping("/ownerdetails")
    public List<OwnerDTO> getAllOwnerDetails(){
        return ownerDTOService.getAllOwnerDTO();
    }

    @GetMapping("ownerdetails/{id}")
    public OwnerDTO getOwnerById(@PathVariable("id") int id){
        OwnerDTO ownerDTO = ownerDTOService.getOwnerDTOByOwnerID(id);
        if (ownerDTO != null){
            return ownerDTO;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "owner id not found");
    }

}
