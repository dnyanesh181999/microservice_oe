package com.cjc.loanapplication.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.NoResourceFoundException;
import com.cjc.loanapplication.model.Customer;
import com.cjc.loanapplication.repository.CustomerRepository;
import com.cjc.loanapplication.servicei.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public List<Customer> getAllCustomer() {
		
		List<Customer> lc= cr.findAll();
		if(!lc.isEmpty())
		{
			List<Customer>list = new ArrayList<Customer>();
			lc.forEach((a)->{
				if(a.getStatus().equals("Pending")) {
					list.add(a);
					
				}
			});
			return list;
		}
		else {
			throw new NoResourceFoundException("Not Any Customer......");
		}
		
	}

	@Override
	public Customer getSingleCutomer(Integer customerId) {
		Optional<Customer> cust=cr.findById(customerId);
		
		if(cust.isPresent())
		{
			Customer c=	cust.get();
		return c;
		}else
		{
			throw new NoResourceFoundException("No Customer Found.....");
		}
	
	}

	@Override
	public Customer statusApproved(Integer customerId) {
		Optional<Customer> os = cr.findById(customerId);
		if(os.isPresent()) {
		Customer cust=os.get();
		cust.setStatus("ApprovedDocument");
		Customer c=cr.save(cust);
		return c;
		}else {
			throw new NoResourceFoundException("Faild to update status");
		}
		
	}

	@Override
	public Customer statusRejected(Integer customerId) {
		Optional<Customer> os = cr.findById(customerId);
		if(os.isPresent()) {
		Customer cust=os.get();
		cust.setStatus("RejectedDocument");
		Customer c=cr.save(cust);
		return c;
		}else {
			throw new NoResourceFoundException("Faild to update status");
		}
	}

	
	
}
