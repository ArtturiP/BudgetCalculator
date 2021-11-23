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
	
	private List<Budget> budgets = new ArrayList<Budget>();
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String home(@RequestParam(name = "budget", required = false)String name, Model model) {

		budgets = new ArrayList<Budget>();
		Budget budget = new Budget();
		model.addAttribute("budget", budget);
		return "index";
	}
	

	
	@RequestMapping(value="/budgetlist")
	public String budgetList(Model model) {
	model.addAttribute("budgets", repository.findAll());
	model.addAttribute("plannedbudgets", prepository.findAll());
	
	return "budgetlist";
	}
	
	@RequestMapping(value = "/add")
	public String addBudget(Model model){
	 model.addAttribute("budget", new Budget());
	 return "addbudget";
	}
	
	@RequestMapping(value = "/addplan")
	public String addPlannedBudget(Model model){
	 model.addAttribute("plannedbudget", new PlannedBudget());
	 return "addplannedbudget";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Budget budget){
	 repository.save(budget);
	 return "redirect:budgetlist";
	}
	
	@RequestMapping(value = "/saveplan", method = RequestMethod.POST)
	public String save(PlannedBudget plannedbudget){
	 prepository.save(plannedbudget);
	 return "redirect:budgetlist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBudget(@PathVariable("id") Long budgetId, Model model) {
	 repository.deleteById(budgetId);
	 return "redirect:../budgetlist";
	}
	
	@RequestMapping(value = "/deleteplan/{id}", method = RequestMethod.GET)
	public String deletePlannedBudget(@PathVariable("id") Long plannedbudgetId, Model model) {
	 prepository.deleteById(plannedbudgetId);
	 return "redirect:../budgetlist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String addBudget(@PathVariable("id") Long budgetId, Model model){
	 model.addAttribute("budget", repository.findById(budgetId));
	 return "editbudget";
	}
	
	@RequestMapping(value = "/editplan/{id}")
	public String addPlannedBudget(@PathVariable("id") Long plannedbudgetId, Model model){
	 model.addAttribute("plannedbudget", prepository.findById(plannedbudgetId));
	 return "editplannedbudget";
	}
	

}
