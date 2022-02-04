package com.example.car_tax_management.entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TaxPayment implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taxpaymentid;
    private boolean installments;
    private String cardnumber;
    private String sortcode;
    private String accountnumber;

    @OneToOne
    @JoinColumn(name ="taxinfoid", referencedColumnName ="taxinfoid")
    private TaxInfo taxinfoid;

    public TaxPayment() {
    }

    public TaxPayment(boolean installments, String cardnumber, String sortcode, String accountnumber) {
        this.installments = installments;
        this.cardnumber = cardnumber;
        this.sortcode = sortcode;
        this.accountnumber = accountnumber;

    }

    public int getTaxpaymentid() {
        return taxpaymentid;
    }

    public void setTaxpaymentid(int taxpaymentid) {
        this.taxpaymentid = taxpaymentid;
    }

    public boolean isInstallments() {
        return installments;
    }

    public void setInstallments(boolean installments) {
        this.installments = installments;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getSortcode() {
        return sortcode;
    }

    public void setSortcode(String sortcode) {
        this.sortcode = sortcode;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public TaxInfo getTaxinfoid() {
        return taxinfoid;
    }

    public void setTaxinfoid(TaxInfo taxinfoid) {
        this.taxinfoid = taxinfoid;
    }
}
