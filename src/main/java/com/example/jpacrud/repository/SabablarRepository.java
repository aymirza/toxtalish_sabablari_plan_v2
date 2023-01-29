package com.example.jpacrud.repository;

import com.example.jpacrud.model.Result;
import com.example.jpacrud.model.Sabablar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SabablarRepository extends JpaRepository<Sabablar,Long> {

    @Query("SELECT s FROM Sabablar s WHERE CONCAT(s.prichina,s.sqolip,s.ssoat,s.sdatecreate) LIKE %?1%")
    public List<Sabablar> search(String poisk);

}
