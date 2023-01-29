package com.example.jpacrud.repository;

import com.example.jpacrud.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Long> {


    @Query("SELECT p FROM Plan p WHERE CONCAT(p.pline11,p.pcikl11,p.pline12,p.pcikl12,p.pline21,p.pcikl21,p.pline22,p.pcikl22,p.pdatecreate) LIKE %?1%")
    public List<Plan> search(String poisk);

}
