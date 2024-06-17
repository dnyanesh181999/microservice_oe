package com.cjc.loanapplication.model;

import jakarta.persistence.Column;
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
public class SanctionLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sanctionId;
	private String sanctionDate;
	private String applicantName;
	private String contact;
	private Double loanAmountSanctioned;
	private String interestType;
	private Float rateOfInterest;
	private Integer loanTenure;
	private Double monthlyEmiAmount;
	private String modeOfPayment;
	@Lob
	@Column(length = 9000000)
	private byte[] sanctionLetter;
	
}
