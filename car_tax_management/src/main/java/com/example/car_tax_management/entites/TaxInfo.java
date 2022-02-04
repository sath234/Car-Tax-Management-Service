package com.example.car_tax_management.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TaxInfo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taxinfoid;
    private int taxduration;
    private LocalDate taxstartdate;
    private LocalDate taxexpirydate;

    @OneToOne
    @JoinColumn(name = "carid", referencedColumnName = "carid")
    private Car carid;

    @OneToOne(mappedBy = "taxinfoid")
    private Sorn sornid;

    @OneToOne(mappedBy = "taxinfoid")
    private TaxPayment taxpaymentid;


    public TaxInfo() {
    }

    public TaxInfo(int taxduration, LocalDate taxstartdate, LocalDate taxexpirydate, Car carid) {
        this.taxduration = taxduration;
        this.taxstartdate = taxstartdate;
        this.taxexpirydate = taxexpirydate;
        this.carid = carid;

    }

    public TaxInfo(int taxduration, String taxstartdate, String taxexpirydate, Car carid) {
        this(taxduration, LocalDate.parse(taxstartdate), LocalDate.parse(taxexpirydate), carid);
    }

    public int getTaxinfoid() {
        return taxinfoid;
    }

    public void setTaxinfoid(int taxinfoid) {
        this.taxinfoid = taxinfoid;
    }

    public int getTaxduration() {
        return taxduration;
    }

    public void setTaxduration(int taxduration) {
        this.taxduration = taxduration;
    }

    public LocalDate getTaxstartdate() {
        return taxstartdate;
    }

    public void setTaxstartdate(LocalDate taxstartdate) {
        this.taxstartdate = taxstartdate;
    }

    public void setTaxstartdate(String taxstartdate) {
        setTaxstartdate(LocalDate.parse(taxstartdate));
    }

    public LocalDate getTaxexpirydate() {
        return taxexpirydate;
    }

    public void setTaxexpirydate(LocalDate taxexpirydate) {
        this.taxexpirydate = taxexpirydate;
    }

    public void setTaxexpirydate(String taxexpirydate) {
        setTaxexpirydate(LocalDate.parse(taxexpirydate));
    }

    public Car getCarid() {
        return carid;
    }

    public void setCarid(Car carid) {
        this.carid = carid;
    }

}

