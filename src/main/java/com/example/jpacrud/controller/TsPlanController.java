package com.example.jpacrud.controller;


import com.example.jpacrud.model.SabablarPlan;
import com.example.jpacrud.service.SabablarPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/plan")
public class TsPlanController {

    @Autowired
    private SabablarPlanService sabablarPlanService;

    @RequestMapping(value = { "/tsplan"})
    public String viewTsPlanPage(Model model, @Param("poiskdate") String poiskdate) {
        if (poiskdate == null) {
            System.out.println("Vvedite datu");
            List<SabablarPlan> sabablarPlanList = sabablarPlanService.listAllSabablarPlan();
            model.addAttribute("sabablarPlanList", sabablarPlanList);
        } else {
            List<SabablarPlan> sabablarPlanList = sabablarPlanService.listAllSabablarPlanPoiskDate(poiskdate);
            model.addAttribute("sabablarPlanList", sabablarPlanList);
            model.addAttribute("poiskdate", poiskdate);
        }
        return "index_plan";
    }

    @RequestMapping("/excel")
    public ResponseEntity<Resource> getFile(@Param("poiskdate") String poiskdate) {
        String filename = "toxtalish_sabablari_faac_ref"+ LocalDateTime.now()+".xlsx";
        InputStreamResource file = new InputStreamResource(sabablarPlanService.exportExcelTsPlan(poiskdate));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }
    @RequestMapping("/newsabablarplan")
    public String showNewSabablarPlanPage(Model model) {
        SabablarPlan sabablarplann = new SabablarPlan();
        model.addAttribute("sabablarplann", sabablarplann);

        return "new_sabablar_plan";
    }

    @RequestMapping(value = "/savesabablarplan", method = RequestMethod.POST)
    public String saveSabablarPlan(@ModelAttribute("savesabablarplan") SabablarPlan savesabablarplan) {
        sabablarPlanService.saveSabablarPlan(savesabablarplan);
        return "redirect:/plan/tsplan";
    }

    @RequestMapping(value = "/showFormForUpdate/{id}", method = RequestMethod.GET)
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        SabablarPlan sabablarPlan = sabablarPlanService.getSabablarPlan(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("sabablarPlan", sabablarPlan);
        return "update_sabablar_plan";
    }

    @RequestMapping("/deleteSabablar/{id}")
    public String deleteSabablarPlan(@PathVariable(name = "id") int id) {
        sabablarPlanService.deleteSabablarPlan(id);
        return "redirect:/";
    }

}