package com.example.BudgetCalculator.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String month;
	private int income;
	private int spend;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getSpend() {
		return spend;
	}
	public void setSpend(int spend) {
		this.spend = spend;
	}	
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Budget() {
	}
	
	public Budget(String month, int income, int spend) {
		super();
		this.month = month;
		this.income = income;
		this.spend = spend;
	}
	
	@Override
	public String toString() {
		return "Budget [id=" + id + ", month=" + month + ", income=" + income + ", spend=" + spend + "]";
	}
	


	
	

}
