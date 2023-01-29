package com.example.jpacrud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "sabablar")
public class Sabablar {
    private Long id_sabablar;
    private String prichina;
    private Integer sqolip;
    private Float ssoat;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "sdatecreate")
    private LocalDate  sdatecreate;
    public Sabablar() {
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_sabablar() {
        return id_sabablar;
    }

    public void setId_sabablar(Long id_sabablar) {
        this.id_sabablar = id_sabablar;
    }
    public String getPrichina() {
        return prichina;
    }

    public void setPrichina(String prichina) {
        this.prichina = prichina;
    }

    public Integer getSqolip() {
        return sqolip;
    }

    public void setSqolip(Integer sqolip) {
        this.sqolip = sqolip;
    }

    public Float getSsoat() {
        return ssoat;
    }

    public void setSsoat(Float ssoat) {
        this.ssoat = ssoat;
    }

    public LocalDate getSdatecreate() {
        return sdatecreate;
    }

    public void setSdatecreate(LocalDate sdatecreate) {
        this.sdatecreate = sdatecreate;
    }

}

