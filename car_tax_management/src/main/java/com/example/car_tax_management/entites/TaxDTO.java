package com.example.car_tax_management.entites;

import java.time.LocalDate;

public class TaxDTO {
    private int ownerid;
    private String numberplate;
    private int taxduration;
    private LocalDate taxstartdate;
    private LocalDate taxexpirydate;
    private boolean installments;

    public TaxDTO() {
    }

    public TaxDTO(String numberplate, int taxduration, LocalDate taxstartdate, LocalDate taxexpirydate, boolean installments) {
        this.numberplate = numberplate;
        this.taxduration = taxduration;
        this.taxstartdate = taxstartdate;
        this.taxexpirydate = taxexpirydate;
        this.installments = installments;
    }

    public TaxDTO(String numberplate, int taxduration, String taxstartdate, String taxexpirydate, boolean installments){
        this(numberplate,taxduration,LocalDate.parse(taxstartdate),LocalDate.parse(taxexpirydate),installments);
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
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

    public boolean isInstallments() {
        return installments;
    }

    public void setInstallments(boolean installments) {
        this.installments = installments;
    }
}
