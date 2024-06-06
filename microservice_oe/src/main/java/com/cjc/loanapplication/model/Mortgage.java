package com.cjc.loanapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mortgage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mortgageId;
	private Double propertyValue;
	private String propertyType;
	private Double loanOnProperty;
	
}
