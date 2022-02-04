package com.example.car_tax_management.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Car implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carid;
    private String numberplate;
    private String vehiclemake;
    private String vehiclecolour;
    private String fueltype;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerid")
    private Owner ownerid;

    @OneToOne(mappedBy = "carid")
    private TaxInfo taxInfoid;

    public Car() {
    }

    public Car(String numberplate, String vehiclemake, String vehiclecolour, String fueltype, Owner ownerid, TaxInfo taxInfoid) {
        this.numberplate = numberplate;
        this.vehiclemake = vehiclemake;
        this.vehiclecolour = vehiclecolour;
        this.fueltype = fueltype;
        this.ownerid = ownerid;
        this.taxInfoid = taxInfoid;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getVehiclemake() {
        return vehiclemake;
    }

    public void setVehiclemake(String vehiclemake) {
        this.vehiclemake = vehiclemake;
    }

    public String getVehiclecolour() {
        return vehiclecolour;
    }

    public void setVehiclecolour(String vehiclecolour) {
        this.vehiclecolour = vehiclecolour;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public Owner getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Owner ownerid) {
        this.ownerid = ownerid;
    }

    public TaxInfo getTaxInfoid() {
        return taxInfoid;
    }

    public void setTaxInfoid(TaxInfo taxInfoid) {
        this.taxInfoid = taxInfoid;
    }
}
