package com.cjc.loanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.Customer;
import com.cjc.loanapplication.servicei.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	
	@Autowired
	CustomerService cs;
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		List<Customer> lc= cs.getAllCustomer();
		return new ResponseEntity<List<Customer>>(lc,HttpStatus.OK);
	}
	
	@GetMapping("/getSingleCustomer/{customerId}")
	public ResponseEntity<Customer> getSingleCustomer(@PathVariable Integer customerId)
	{
		Customer cust=cs.getSingleCutomer(customerId);
		if(cust!=null) {
			return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateApprovedStatus/{customerId}")
	public ResponseEntity<Customer> statusApproved(@PathVariable Integer customerId)
	{
		Customer c=cs.statusApproved(customerId);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
		
	}
	@PutMapping("/updateRejectStatus/{customerId}")
	public ResponseEntity<Customer> statusRejected(@PathVariable Integer customerId)
	{
		Customer c=cs.statusRejected(customerId);

		return new ResponseEntity<Customer>(c,HttpStatus.OK);
		
	}

}
