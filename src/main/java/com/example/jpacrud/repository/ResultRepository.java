package com.example.jpacrud.repository;

import com.example.jpacrud.model.Plan;
import com.example.jpacrud.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result,Long> {

    @Query("SELECT r FROM Result r WHERE CONCAT(r.rline11,r.rcikl11,r.rline12,r.rcikl12,r.rline21,r.rcikl21,r.rline22,r.rcikl22,r.rdatecreate) LIKE %?1%")
    public List<Result> search(String poisk);
}
