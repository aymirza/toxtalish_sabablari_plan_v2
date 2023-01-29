package com.example.jpacrud.repository;

import com.example.jpacrud.model.Sabablar;
import com.example.jpacrud.model.SabablarPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SabablarPlanRepository extends JpaRepository<SabablarPlan,Long> {

    @Query("SELECT sp FROM SabablarPlan sp WHERE CONCAT(sp.uchastka,sp.nachalnik,sp.master,sp.brigadir,sp.smena,sp.toxtalishsababi,sp.toxtalishnuktasi,sp.toxtalishdate,sp.starttime,sp.finishtime,sp.toxtaganvaqt,sp.mkiritishfio) LIKE %?1%")
    public List<SabablarPlan> searchDate(String poiskdate);

}
