package com.example.car_tax_management.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Owner implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerid;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String phonenumber;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressid")
    private Address addressid;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Car.class, mappedBy = "ownerid")
    private List<Car> carid;

    public Owner() {
    }

    public Owner(String firstname, String lastname, LocalDate dob, String phonenumber, String email, Address addressid, List<Car> carid) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.phonenumber = phonenumber;
        this.email = email;
        this.addressid = addressid;
        this.carid = carid;
    }

    public Owner(String firstname, String lastname, String dob, String phonenumber, String email, Address addressid, List<Car> carid) {
        this(firstname, lastname, LocalDate.parse(dob), phonenumber,email,addressid, carid);
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

    public Address getAddressid() {
        return addressid;
    }

    public void setAddressid(Address addressid) {
        this.addressid = addressid;
    }

    public List<Car> getCarid() {
        return carid;
    }

    public void setCarid(List<Car> carid) {
        this.carid = carid;
    }
}
