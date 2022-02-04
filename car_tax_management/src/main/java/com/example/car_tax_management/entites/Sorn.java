package com.example.car_tax_management.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Sorn implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sornid;
    private LocalDate sorndate;
    private boolean sornstatus;

    @OneToOne
    @JoinColumn(name = "taxinfoid", referencedColumnName = "taxinfoid")
    private TaxInfo taxinfoid;

    public Sorn() {
    }

    public Sorn(LocalDate sorndate, boolean sornstatus) {
        this.sorndate = sorndate;
        this.sornstatus = sornstatus;

    }

    public Sorn(String sorndate, boolean sornstatus){
        this(LocalDate.parse(sorndate),sornstatus);
    }

    public int getSornid() {
        return sornid;
    }

    public void setSornid(int sornid) {
        this.sornid = sornid;
    }

    public LocalDate getSorndate() {
        return sorndate;
    }

    public void setSorndate(LocalDate sorndate) {
        this.sorndate = sorndate;
    }

    public void setSorndate(String sorndate) {
        setSorndate(LocalDate.parse(sorndate));
    }

    public boolean isSornstatus() {
        return sornstatus;
    }

    public void setSornstatus(boolean sornstatus) {
        this.sornstatus = sornstatus;
    }

    public TaxInfo getTaxinfoid() {
        return taxinfoid;
    }

    public void setTaxinfoid(TaxInfo taxinfoid) {
        this.taxinfoid = taxinfoid;
    }
}
