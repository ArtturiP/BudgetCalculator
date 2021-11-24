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
	private String month; //budjetin kuukausi
	private int salary; //palkka
	private int otherinc; //muut tulot
	private int income; //tulot yhteensä
	private int rent; //vuokra
	private int bills; //laskut
	private int food; //ruoka
	private int essentials; //välttämättömät menot
	private int entertainment; //viihde
	private int otherspe; //muut menot
	private int spend; //menot yhteensä
	
	//getterit ja setterit
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getOtherinc() {
		return otherinc;
	}
	public void setOtherinc(int otherinc) {
		this.otherinc = otherinc;
	}
	public int getIncome() {
		return salary + otherinc;
	}
	public void setIncome(int income) {
		this.income = salary + otherinc;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getBills() {
		return bills;
	}
	public void setBills(int bills) {
		this.bills = bills;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getEssentials() {
		return essentials;
	}
	public void setEssentials(int essentials) {
		this.essentials = essentials;
	}
	public int getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(int entertainment) {
		this.entertainment = entertainment;
	}
	public int getOtherspe() {
		return otherspe;
	}
	public void setOtherspe(int otherspe) {
		this.otherspe = otherspe;
	}
	public int getSpend() {
		return rent + bills + food + essentials + entertainment + otherspe;
	}
	public void setSpend(int spend) {
		this.spend = rent + bills + food + essentials + entertainment + otherspe;
	}
	
	//konstruktorit
	public Budget() {
		super();
	}
	
	public Budget(String month, int salary, int otherinc, int income, int rent, int bills, int food,
			int essentials, int entertainment, int otherspe, int spend) {
		super();
		this.month = month;
		this.salary = salary;
		this.otherinc = otherinc;
		this.income = income;
		this.rent = rent;
		this.bills = bills;
		this.food = food;
		this.essentials = essentials;
		this.entertainment = entertainment;
		this.otherspe = otherspe;
		this.spend = spend;
	}
	
	@Override
	public String toString() {
		return "Budget [id=" + id + ", month=" + month + ", salary=" + salary + ", otherinc=" + otherinc + ", income="
				+ income + ", rent=" + rent + ", bills=" + bills + ", food=" + food + ", essentials=" + essentials
				+ ", entertainment=" + entertainment + ", otherspe=" + otherspe + ", spend=" + spend + "]";
	}
	
	
	
}
