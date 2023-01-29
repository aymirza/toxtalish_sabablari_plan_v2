package com.example.jpacrud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sabablarplan")
public class SabablarPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uchastka;
    private String nachalnik;
    private String master;
    private String brigadir;
    private String smena;
    private String toxtalishsababi;
    private String toxtalishnuktasi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "sdatecreateplan")
    private LocalDate toxtalishdate;
    private String starttime;
    private String finishtime;
    private String toxtaganvaqt;
    private String mkiritishfio;

    public SabablarPlan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUchastka() {
        return uchastka;
    }

    public void setUchastka(String uchastka) {
        this.uchastka = uchastka;
    }

    public String getNachalnik() {
        return nachalnik;
    }

    public void setNachalnik(String nachalnik) {
        this.nachalnik = nachalnik;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getBrigadir() {
        return brigadir;
    }

    public void setBrigadir(String brigadir) {
        this.brigadir = brigadir;
    }

    public String getSmena() {
        return smena;
    }

    public void setSmena(String smena) {
        this.smena = smena;
    }

    public String getToxtalishsababi() {
        return toxtalishsababi;
    }

    public void setToxtalishsababi(String toxtalishsababi) {
        this.toxtalishsababi = toxtalishsababi;
    }

    public String getToxtalishnuktasi() {
        return toxtalishnuktasi;
    }

    public void setToxtalishnuktasi(String toxtalishnuktasi) {
        this.toxtalishnuktasi = toxtalishnuktasi;
    }

    public LocalDate getToxtalishdate() {
        return toxtalishdate;
    }

    public void setToxtalishdate(LocalDate toxtalishdate) {
        this.toxtalishdate = toxtalishdate;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getToxtaganvaqt() {
        return toxtaganvaqt;
    }

    public void setToxtaganvaqt(String toxtaganvaqt) {
        this.toxtaganvaqt = toxtaganvaqt;
    }

    public String getMkiritishfio() {
        return mkiritishfio;
    }

    public void setMkiritishfio(String mkiritishfio) {
        this.mkiritishfio = mkiritishfio;
    }
}

