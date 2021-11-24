package com.example.BudgetCalculator.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BudgetCalculator.domain.Budget;
import com.example.BudgetCalculator.domain.BudgetRepository;
import com.example.BudgetCalculator.domain.PlannedBudget;
import com.example.BudgetCalculator.domain.PlannedRepository;


@Controller
public class BudgetController {
	
	@Autowired
	private BudgetRepository repository;
	
	@Autowired
	private PlannedRepository prepository;
	
	// kotisivu
	@RequestMapping(value = {"/", "/index"})
	public String home () {
		return "index";
	}

	//lista budjeteista
	@RequestMapping(value="/budgets")
	public String budgetList(Model model) {
	//haetaan menneistä budjetit
	model.addAttribute("budgets", repository.findAll());
	//haetaan suunnitellut budjetit
	model.addAttribute("plannedbudgets", prepository.findAll());
	return "budgets";
	}
	
	//lisätään menneitä budjetteja
	@RequestMapping(value = "/add")
	public String addBudget(Model model){
	 //lisätään budjetti listaan
	 model.addAttribute("budget", new Budget());
	 return "addbudget";
	}
	
	//lisätään budjettisuunnitelmia
	@RequestMapping(value = "/addplan")
	public String addPlannedBudget(Model model){
	 //lisätään budjetti listaan
	 model.addAttribute("plannedbudget", new PlannedBudget());
	 return "addplannedbudget";
	}
	
	//menneiden budjettien tallennus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Budget budget){
	 repository.save(budget);
	 //siirrytään takaisin budjettilistaukseen
	 return "redirect:budgets";
	}
	
	//budjettisuunnitelmien tallennus
	@RequestMapping(value = "/saveplan", method = RequestMethod.POST)
	public String save(PlannedBudget plannedbudget){
	 prepository.save(plannedbudget);
	 //siirrytään takaisin budjettilistaukseen
	 return "redirect:budgets";
	}
	
	//menneiden budjettien poisto
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBudget(@PathVariable("id") Long budgetId, Model model) {
	 //poistetaan id:n perusteella
	 repository.deleteById(budgetId);
	//siirrytään takaisin budjettilistaukseen
	 return "redirect:../budgets";
	}
	
	//budjettisuunnitelmien poisto
	@RequestMapping(value = "/deleteplan/{id}", method = RequestMethod.GET)
	public String deletePlannedBudget(@PathVariable("id") Long plannedbudgetId, Model model) {
	 //poistetaan id:n perusteella
	 prepository.deleteById(plannedbudgetId);
	//siirrytään takaisin budjettilistaukseen
	 return "redirect:../budgets";
	}
	
	//menneiden budjettien muokkaus
	@RequestMapping(value = "/edit/{id}")
	public String addBudget(@PathVariable("id") Long budgetId, Model model){
	 //tallennetaan tiedot id:n perusteella
	 model.addAttribute("budget", repository.findById(budgetId));
	 return "editbudget";
	}
	
	//budjettisuunnitelmien muokkaus
	@RequestMapping(value = "/editplan/{id}")
	public String addPlannedBudget(@PathVariable("id") Long plannedbudgetId, Model model){
	 //tallennetaan tiedot id:n perusteella
	 model.addAttribute("plannedbudget", prepository.findById(plannedbudgetId));
	 return "editplannedbudget";
	}
	

}
