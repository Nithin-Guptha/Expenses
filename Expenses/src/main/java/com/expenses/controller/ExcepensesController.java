package com.expenses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import com.expenses.entity.ExpensesEntity;
import com.expenses.service.AddExcepensesService;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
//@RequestMapping("/")
public class ExcepensesController {

    @Autowired
    private AddExcepensesService addExcepensesService;
    
    @GetMapping("/add_expenses")    
    public String showExpenditureForm(Model model) {
//    	model.addAttribute("ExpensesEntity" new ExpensesEntity);
    	model.addAttribute("expensesEntity", new ExpensesEntity());
    	return "Expenditure";
    	
    }
    
    
    
    @PostMapping("/add_expenses")
    public String addExpenditure(@ModelAttribute ExpensesEntity expensesEntity,Model model) {
        String message = addExcepensesService.addExpenses(expensesEntity);
        model.addAttribute("message", message);
        if(message.equalsIgnoreCase("success")) {
        	 return "redirect:/expenditure";
        }
        model.addAttribute("message", "Failed to add expense");
        return "Expenditure";
        
    }
    
    @GetMapping("/expenditure")
    public String getExpenditure(Model model) {
        List<ExpensesEntity> expenses = addExcepensesService.getData();
        model.addAttribute("expenses", expenses);
        return "Expenditure";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editExpenditure(@PathVariable Long id, Model model) {
        ExpensesEntity expense = addExcepensesService.getById(id);
        model.addAttribute("expensesEntity", expense);
        return "UpdateExpenditure";
    }

    @PostMapping("/update")
    public String updateExpenditure(@ModelAttribute ExpensesEntity expensesEntity, Model model) {
        addExcepensesService.updateExpense(expensesEntity);
        model.addAttribute("message", "Updated successfully for ID: " + expensesEntity.getId());
        return "redirect:/expenditure";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpenditure(@PathVariable Long id, Model model) {
        addExcepensesService.deleteExpense(id);
        model.addAttribute("message", "Record deleted successfully: ID " + id);
        return "redirect:/expenditure";
    }
}
