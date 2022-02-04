package com.example.car_tax_management.repositories;

import com.example.car_tax_management.entites.OwnerDTO;
import com.example.car_tax_management.entites.TaxDTO;
import com.example.car_tax_management.services.TaxDTOService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Tax Details Entity")
@RestController
@CrossOrigin
public class TaxDetailsRepository {
    @Autowired
    private TaxDTOService taxDTOService;

    @GetMapping("/taxdetails")
    public List<TaxDTO> getAllTaxDetails(){
        return taxDTOService.getAllTaxDTO();
    }

    @GetMapping("taxdetails/{id}")
    public TaxDTO getOwnerById(@PathVariable("id") int id){
        TaxDTO taxDTO = taxDTOService.getTaxDTOBYTaxID(id);
        if (taxDTO != null){
            return taxDTO;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "owner id not found");
    }
}
