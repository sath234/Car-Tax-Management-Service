package com.example.car_tax_management.services;

import com.example.car_tax_management.entites.Car;
import com.example.car_tax_management.entites.OwnerDTO;
import com.example.car_tax_management.entites.TaxDTO;
import com.example.car_tax_management.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerDTOService {
    @Autowired
    CarRepository carRepository;

    private OwnerDTO convertToOwnerDTO(Car car){
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setOwnerid(car.getOwnerid().getOwnerid());
        ownerDTO.setNumberplate(car.getNumberplate());
        ownerDTO.setFirstname(car.getOwnerid().getFirstname());
        ownerDTO.setLastname(car.getOwnerid().getLastname());
        ownerDTO.setDob(car.getOwnerid().getDob());
        ownerDTO.setPhonenumber(car.getOwnerid().getPhonenumber());
        ownerDTO.setEmail(car.getOwnerid().getEmail());
        ownerDTO.setVehiclemake(car.getVehiclemake());
        ownerDTO.setVehiclecolour(car.getVehiclecolour());
        ownerDTO.setFueltype(car.getFueltype());
        ownerDTO.setNameornumber(car.getOwnerid().getAddressid().getNameornumber());
        ownerDTO.setStreet(car.getOwnerid().getAddressid().getStreet());
        ownerDTO.setPostcode(car.getOwnerid().getAddressid().getPostcode());
        ownerDTO.setCounty(car.getOwnerid().getAddressid().getCounty());
        ownerDTO.setCountry(car.getOwnerid().getAddressid().getCountry());

        return ownerDTO;
    }

    public List<OwnerDTO> getAllOwnerDTO(){
        return ((List<Car>)carRepository.findAll()).stream().map(this::convertToOwnerDTO).collect(Collectors.toList());
    }

    public OwnerDTO getOwnerDTOByOwnerID(int id){
        List<OwnerDTO> ownerDTOList = getAllOwnerDTO();
        for (OwnerDTO ownerDTO: ownerDTOList){
            if (ownerDTO.getOwnerid() == id){
                return ownerDTO;
            }
        }
        return null;
    }

}
