package com.example.car_tax_management.services;

import com.example.car_tax_management.entites.Car;
import com.example.car_tax_management.entites.TaxDTO;
import com.example.car_tax_management.entites.TaxPayment;
import com.example.car_tax_management.repositories.TaxPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxDTOService {
    @Autowired
    TaxPaymentRepository taxPaymentRepository;

    private TaxDTO convertToTaxDTO(TaxPayment taxPayment){
        TaxDTO taxDTO = new TaxDTO();
        taxDTO.setOwnerid(taxPayment.getTaxinfoid().getCarid().getOwnerid().getOwnerid());
        taxDTO.setNumberplate(taxPayment.getTaxinfoid().getCarid().getNumberplate());
        taxDTO.setTaxduration(taxPayment.getTaxinfoid().getTaxduration());
        taxDTO.setInstallments(taxPayment.isInstallments());
        taxDTO.setTaxstartdate(taxPayment.getTaxinfoid().getTaxstartdate());
        taxDTO.setTaxexpirydate(taxPayment.getTaxinfoid().getTaxexpirydate());
        return taxDTO;
    }

    public List<TaxDTO> getAllTaxDTO(){
        return ((List<TaxPayment>)taxPaymentRepository.findAll()).stream().map(this::convertToTaxDTO).collect(Collectors.toList());
    }

    public TaxDTO getTaxDTOBYTaxID(int id){
        List<TaxDTO> taxDTOList = getAllTaxDTO();
        for (TaxDTO taxDTO: taxDTOList){
            if (taxDTO.getOwnerid() == id){
                return taxDTO;
            }
        }
        return null;
    }

}
