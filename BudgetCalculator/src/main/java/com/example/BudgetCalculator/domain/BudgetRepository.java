package com.example.BudgetCalculator.domain;

import org.springframework.data.repository.CrudRepository;

//repo menneille budjeteille
public interface BudgetRepository extends CrudRepository<Budget, Long> {

}
