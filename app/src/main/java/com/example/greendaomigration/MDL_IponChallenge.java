package com.example.greendaomigration;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MDL_IponChallenge {
    @Property(nameInDb = "piso")
    private int piso;

    @Property(nameInDb = "bente")
    private int bente;

    @Property(nameInDb = "sinkwenta")
    private int sinkwenta;

    @Generated(hash = 1607311657)
    public MDL_IponChallenge(int piso, int bente, int sinkwenta) {
        this.piso = piso;
        this.bente = bente;
        this.sinkwenta = sinkwenta;
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
}
