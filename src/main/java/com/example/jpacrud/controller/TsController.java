package com.example.jpacrud.controller;


import com.example.jpacrud.model.*;
import com.example.jpacrud.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TsController {

    @Autowired
    private PlanService planService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private SabablarService sabablarService;

    @RequestMapping("/tsturk")
    public String viewTsPage(Model model,@Param("poisk") String poisk) {
        if(poisk==null) {
            System.out.println("Vvedite datu");
        }else {
            List<Plan> planList = planService.listAllPlan(poisk);
            List<Result> resultList = resultService.listAllResult(poisk);
            List<Sabablar> sabablarList = sabablarService.listAllSabablar(poisk);
            model.addAttribute("planList", planList);
            model.addAttribute("resultList", resultList);
            model.addAttribute("sabablarList", sabablarList);
            model.addAttribute("poisk", poisk);
        }
        return "index_ts_turk";
    }

    @RequestMapping("/newPlan")
    public String showNewPlanPage(Model model) {
        Plan plan = new Plan();
        model.addAttribute("plan", plan);

        return "new_plan";
    }
    @RequestMapping(value = "/savePlan", method = RequestMethod.POST)
    public String savePlan(@ModelAttribute("plan") Plan plan) {
        planService.savePlan(plan);
        return "redirect:/";
    }
    @RequestMapping("/newResult")
    public String showNewResultPage(Model model) {
        Result result = new Result();
        model.addAttribute("result", result);

        return "new_result";
    }
    @RequestMapping(value = "/saveResult", method = RequestMethod.POST)
    public String saveResult(@ModelAttribute("result") Result result) {
        resultService.saveResult(result);
        return "redirect:/";
    }
    @RequestMapping("/newSabablar")
    public String showNewSabablarPage(Model model) {
        Sabablar sabablar = new Sabablar();
        model.addAttribute("sabablar", sabablar);

        return "new_sabablar";
    }
    @RequestMapping(value = "/saveSabablar", method = RequestMethod.POST)
    public String saveSabablar(@ModelAttribute("sabablar") Sabablar sabablar) {
        sabablarService.saveSabablar(sabablar);
        return "redirect:/";
    }
    @RequestMapping("/deletePlan/{id}")
    public String deletePlan(@PathVariable(name = "id") int id) {
        planService.deletePlan(id);
        return "redirect:/";
    }
    @RequestMapping("/deleteResult/{id}")
    public String deleteResult(@PathVariable(name = "id") int id) {
        resultService.deleteResult(id);
        return "redirect:/";
    }
    @RequestMapping("/deleteSabablar/{id}")
    public String deleteSabablar(@PathVariable(name = "id") int id) {
        sabablarService.deleteSabablar(id);
        return "redirect:/";
    }

    @RequestMapping("/plan")
    public String viewTsPagePlan(Model model,@Param("poisk") String poisk) {
        if(poisk==null) {
            System.out.println("Vvedite datu");
        }else {
            List<Sabablar> sabablarList = sabablarService.listAllSabablar(poisk);
            model.addAttribute("sabablarList", sabablarList);
            model.addAttribute("poisk", poisk);
        }
        return "index_ts_turk";
    }



}