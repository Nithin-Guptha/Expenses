package com.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expenses.entity.ExpensesEntity;

@Repository
public interface AddExcepensesRepository extends JpaRepository<ExpensesEntity, Long>{

}
