package com.example.jpacrud.service;

import com.example.jpacrud.model.Result;
import com.example.jpacrud.model.Sabablar;
import com.example.jpacrud.repository.SabablarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SabablarService {

    @Autowired
    private SabablarRepository sabablarRepository;

    public List<Sabablar> listAllSabablar(String poisk) {
        if (poisk != null){
            return sabablarRepository.search(poisk);
        }
        return sabablarRepository.findAll();
    }

    public void saveSabablar(Sabablar sabablar) {
        sabablarRepository.save(sabablar);
    }

    public Sabablar getSabablar(long id_result) {
        return sabablarRepository.findById(id_result).get();
    }

    public void deleteSabablar(long id_result) {
        sabablarRepository.deleteById(id_result);
    }
}