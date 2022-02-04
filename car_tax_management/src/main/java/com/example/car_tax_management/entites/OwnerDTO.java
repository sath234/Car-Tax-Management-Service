package com.example.car_tax_management.entites;

import java.time.LocalDate;

public class OwnerDTO {
    private int ownerid;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String phonenumber;
    private String email;
    private String numberplate;
    private String nameornumber;
    private String street;
    private String postcode;
    private String county;
    private String country;
    private String vehiclemake;
    private String vehiclecolour;
    private String fueltype;

    public OwnerDTO() {
    }

    public OwnerDTO(String firstname, String lastname, LocalDate dob, String phonenumber, String email, String numberplate, String nameornumber, String street, String postcode, String county, String country, String vehiclemake, String vehiclecolour, String fueltype) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.email = email;
        this.numberplate = numberplate;
        this.nameornumber = nameornumber;
        this.street = street;
        this.postcode = postcode;
        this.county = county;
        this.country = country;
        this.vehiclemake = vehiclemake;
        this.vehiclecolour = vehiclecolour;
        this.fueltype = fueltype;
    }

    public OwnerDTO(String firstname, String lastname, String dob, String phonenumber, String email, String numberplate, String nameornumber, String street, String postcode, String county, String country, String vehiclemake, String vehiclecolour, String fueltype){
        this(firstname,lastname,LocalDate.parse(dob),phonenumber,email,numberplate,nameornumber,street,postcode,county,country,vehiclemake,vehiclecolour,fueltype);
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDob(String dob) {
        setDob(LocalDate.parse(dob));
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
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
}
