package com.example.jpacrud.repository;


import com.example.jpacrud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.brand, p.madein, p.price, p.dtcreate) LIKE %?1%")
    public List<Product> search(String keyword);


}
