package com.cjc.loanapplication.servicei;

import java.util.List;

import com.cjc.loanapplication.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomer();

	Customer getSingleCutomer(Integer customerId);

	Customer statusApproved(Integer customerId);

	Customer statusRejected(Integer customerId);

}
