package com.example.BudgetCalculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.BudgetCalculator.domain.BudgetRepository;
import com.example.BudgetCalculator.domain.PlannedRepository;

//budjettilaskurin sovellus
@SpringBootApplication
public class BudgetCalculatorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BudgetCalculatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BudgetRepository repository, PlannedRepository prepository) {
		return (args) -> {
			
		};
	}
}
