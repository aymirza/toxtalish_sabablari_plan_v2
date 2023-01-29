package com.example.jpacrud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plan")
public class Plan {
    private Long id_plan;
    private Integer pline11;
    private Float pcikl11;
    private Integer pline12;
    private Float pcikl12;
    private Integer pline21;
    private Float pcikl21;
    private Integer pline22;
    private Float pcikl22;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "pdatecreate")
    private LocalDate pdatecreate;

    public Plan() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_plan() {
        return id_plan;
    }

    public void setId_plan(Long id_plan) {
        this.id_plan = id_plan;
    }

    public Integer getPline11() {
        return pline11;
    }

    public void setPline11(Integer pline11) {
        this.pline11 = pline11;
    }

    public Float getPcikl11() {
        return pcikl11;
    }

    public void setPcikl11(Float pcikl11) {
        this.pcikl11 = pcikl11;
    }

    public Integer getPline12() {
        return pline12;
    }

    public void setPline12(Integer pline12) {
        this.pline12 = pline12;
    }

    public Float getPcikl12() {
        return pcikl12;
    }

    public void setPcikl12(Float pcikl12) {
        this.pcikl12 = pcikl12;
    }

    public Integer getPline21() {
        return pline21;
    }

    public void setPline21(Integer pline21) {
        this.pline21 = pline21;
    }

    public Float getPcikl21() {
        return pcikl21;
    }

    public void setPcikl21(Float pcikl21) {
        this.pcikl21 = pcikl21;
    }

    public Integer getPline22() {
        return pline22;
    }

    public void setPline22(Integer pline22) {
        this.pline22 = pline22;
    }

    public Float getPcikl22() {
        return pcikl22;
    }

    public void setPcikl22(Float pcikl22) {
        this.pcikl22 = pcikl22;
    }


    public LocalDate getPdatecreate() {
        return pdatecreate;
    }

    public void setPdatecreate(LocalDate pdatecreate) {
        this.pdatecreate = pdatecreate;
    }
}
