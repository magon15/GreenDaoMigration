package com.example.greendaomigration;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MDL_IponChallenge {

    @Property(nameInDb = "currency")
    private String currency;

    @Property(nameInDb = "piso")
    private int piso;

    @Property(nameInDb = "bente")
    private int bente;

    @Property(nameInDb = "sinkwenta")
    private int sinkwenta;

    @Property(nameInDb = "penny")
    private int penny;

    @Property(nameInDb = "dime")
    private int dime;

    @Property(nameInDb = "quarter")
    private int quarter;

    public MDL_IponChallenge(String currency, int value1, int value2, int value3){
        this.currency = currency;
        if(currency.equals("PHP")){
            this.piso = value1;
            this.bente = value2;
            this.sinkwenta = value3;
        }else{
            this.penny = value1;
            this.dime = value2;
            this.quarter = value3;
        }
    }

    @Generated(hash = 1759077536)
    public MDL_IponChallenge(String currency, int piso, int bente, int sinkwenta,
            int penny, int dime, int quarter) {
        this.currency = currency;
        this.piso = piso;
        this.bente = bente;
        this.sinkwenta = sinkwenta;
        this.penny = penny;
        this.dime = dime;
        this.quarter = quarter;
    }

    @Generated(hash = 707585879)
    public MDL_IponChallenge() {
    }

    public int getPiso() {
        return this.piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getBente() {
        return this.bente;
    }

    public void setBente(int bente) {
        this.bente = bente;
    }

    public int getSinkwenta() {
        return this.sinkwenta;
    }

    public void setSinkwenta(int sinkwenta) {
        this.sinkwenta = sinkwenta;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPenny() {
        return this.penny;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }

    public int getDime() {
        return this.dime;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    public int getQuarter() {
        return this.quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }
}
