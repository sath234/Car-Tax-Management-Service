package com.example.car_tax_management.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Address implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adressid;
    private String nameornumber;
    private String street;
    private String postcode;
    private String county;
    private String country;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Owner.class, mappedBy = "addressid")
    private List<Owner> ownerid;

    public Address() {
    }

    public Address(String nameornumber, String street, String postcode, String county, String country, List<Owner> ownerid) {
        this.nameornumber = nameornumber;
        this.street = street;
        this.postcode = postcode;
        this.county = county;
        this.country = country;
        this.ownerid = ownerid;
    }

    public int getAdressid() {
        return adressid;
    }

    public void setAdressid(int adressid) {
        this.adressid = adressid;
    }

    public String getNameornumber() {
        return nameornumber;
    }

    public void setNameornumber(String nameornumber) {
        this.nameornumber = nameornumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Owner> getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(List<Owner> ownerid) {
        this.ownerid = ownerid;
    }
}
