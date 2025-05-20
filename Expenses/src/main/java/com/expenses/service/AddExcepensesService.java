package com.expenses.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.entity.ExpensesEntity;
import com.expenses.repository.AddExcepensesRepository;

@Service
public class AddExcepensesService {

	@Autowired
	private AddExcepensesRepository addExcepensesRepository;
	public String addExpenses(ExpensesEntity expensesEntity) {
		
		 boolean valid = addExcepensesRepository.save(expensesEntity) != null;
		 return valid ? "success":"fail";
	}
	
	public List<ExpensesEntity> getData() {
		return addExcepensesRepository.findAll();
	}
	
	 public ExpensesEntity getById(Long id) {
	        return addExcepensesRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
	    }

	    public void updateExpense(ExpensesEntity updated) {
	    	addExcepensesRepository.save(updated);
	    }

	    public void deleteExpense(Long id) {
	    	addExcepensesRepository.deleteById(id);
	    }

}
