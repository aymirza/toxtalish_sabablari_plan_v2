package com.example.jpacrud.service;

import com.example.jpacrud.config.TsPlanExcelExporter;
import com.example.jpacrud.model.Sabablar;
import com.example.jpacrud.model.SabablarPlan;
import com.example.jpacrud.repository.SabablarPlanRepository;
import com.example.jpacrud.repository.SabablarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.util.List;

@Service
@Transactional
public class SabablarPlanService {

    @Autowired
    private SabablarPlanRepository sabablarPlanRepository;

    public List<SabablarPlan> listAllSabablarPlanPoiskDate(String poiskdate) {
        if (poiskdate != null){
            return sabablarPlanRepository.searchDate(poiskdate);
        }
        return sabablarPlanRepository.findAll();
    }

    public ByteArrayInputStream exportExcelTsPlan(String poiskdate) {
        if (poiskdate != null){
            List<SabablarPlan> sabablarPlanList = sabablarPlanRepository.searchDate(poiskdate);
            ByteArrayInputStream inputStream = TsPlanExcelExporter.tutorialsToExcel(sabablarPlanList);
            return inputStream;
        }else {
            return (ByteArrayInputStream) sabablarPlanRepository.findAll();
        }
    }
    public List<SabablarPlan> listAllSabablarPlan() {
        return sabablarPlanRepository.findAll();
    }

    public void saveSabablarPlan(SabablarPlan sabablarplan) {
        sabablarPlanRepository.save(sabablarplan);
    }

    public SabablarPlan getSabablarPlan(long id) {
        return sabablarPlanRepository.findById(id).get();
    }

    public void deleteSabablarPlan(long id_result) {
        sabablarPlanRepository.deleteById(id_result);
    }



}