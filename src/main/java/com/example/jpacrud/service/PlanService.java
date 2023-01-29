package com.example.jpacrud.service;

import com.example.jpacrud.model.Plan;
import com.example.jpacrud.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlanService {
    @Autowired
    private PlanRepository planRepository;
    public List<Plan> listAllPlan(String poisk) {
        if (poisk != null){
            return planRepository.search(poisk);
        }
        return planRepository.findAll();
    }

    public void savePlan(Plan plan) {
        planRepository.save(plan);
    }

    public Plan getPlan(long id_plan) {
        return planRepository.findById(id_plan).get();
    }

    public void deletePlan(long id_plan) {
        planRepository.deleteById(id_plan);
    }
}

