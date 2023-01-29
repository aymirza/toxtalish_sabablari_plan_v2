package com.example.jpacrud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "result")
public class Result {
    private Long id_result;
    private Integer rline11;
    private Float rcikl11;
    private Integer rline21;
    private Float rcikl21;
    private Integer rline12;
    private Float rcikl12;
    private Integer rline22;
    private Float rcikl22;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "rdatecreate")
    private LocalDate  rdatecreate;

    public Result() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getId_result() {
        return id_result;
    }

    public void setId_result(Long id_result) {
        this.id_result = id_result;
    }

    public Integer getRline11() {
        return rline11;
    }

    public void setRline11(Integer rline11) {
        this.rline11 = rline11;
    }

    public Float getRcikl11() {
        return rcikl11;
    }

    public void setRcikl11(Float rcikl11) {
        this.rcikl11 = rcikl11;
    }

    public Integer getRline21() {
        return rline21;
    }

    public void setRline21(Integer rline21) {
        this.rline21 = rline21;
    }

    public Float getRcikl21() {
        return rcikl21;
    }

    public void setRcikl21(Float rcikl21) {
        this.rcikl21 = rcikl21;
    }

    public Integer getRline12() {
        return rline12;
    }

    public void setRline12(Integer rline12) {
        this.rline12 = rline12;
    }

    public Float getRcikl12() {
        return rcikl12;
    }

    public void setRcikl12(Float rcikl12) {
        this.rcikl12 = rcikl12;
    }

    public Integer getRline22() {
        return rline22;
    }

    public void setRline22(Integer rline22) {
        this.rline22 = rline22;
    }

    public Float getRcikl22() {
        return rcikl22;
    }

    public void setRcikl22(Float rcikl22) {
        this.rcikl22 = rcikl22;
    }



    public LocalDate getRdatecreate() {
        return rdatecreate;
    }

    public void setRdatecreate(LocalDate rdatecreate) {
        this.rdatecreate = rdatecreate;
    }
}