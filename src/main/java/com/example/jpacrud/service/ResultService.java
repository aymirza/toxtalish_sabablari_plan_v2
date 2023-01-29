package com.example.jpacrud.service;


import com.example.jpacrud.model.Plan;
import com.example.jpacrud.model.Result;
import com.example.jpacrud.repository.PlanRepository;
import com.example.jpacrud.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;
    public List<Result> listAllResult(String poisk) {
        if (poisk != null){
            return resultRepository.search(poisk);
        }
        return resultRepository.findAll();
    }

    public void saveResult(Result result) {
        resultRepository.save(result);
    }

    public Result getResult(long id_result) {
        return resultRepository.findById(id_result).get();
    }

    public void deleteResult(long id_result) {
        resultRepository.deleteById(id_result);
    }
}

