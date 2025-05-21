package com.expenses.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="expenditure")
public class ExpensesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="ID")
	private long id;
	
	@Column(name="DATE")
	 @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date = LocalDate.now();
	
	@Column(name="AMOUNT")
	private String amount;
	
	@Column(name="PURPOUS")
	private String purpous;
}
