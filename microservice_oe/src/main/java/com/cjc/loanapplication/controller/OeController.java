package com.cjc.loanapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.EmailForSendingEnquiryToOE;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.OeServicei;

import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("oe")
public class OeController {
	@Autowired
	OeServicei os;
	@GetMapping("/oe")
	public ResponseEntity<List<Enquiry>>getAllFtoe(){
		List<Enquiry>list=os.getAllFtoe();
		if(!list.isEmpty()) {
			log.info("Enquiry data get Successfully");
			return new ResponseEntity<List<Enquiry>>(list,HttpStatus.OK);
		}
		else {
			log.error("Enquiry not Found...");
			return new ResponseEntity<List<Enquiry>>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/oe/{enquiryId}")
	public ResponseEntity<Enquiry> checkCibil(@RequestBody Enquiry e,@PathVariable Integer enquiryId,EmailForSendingEnquiryToOE email) {
		Enquiry enq = os.checkCibil(e,enquiryId,email);
		if(enq!=null)
		{
			log.info("Cibile checked and remark Updated....");
		return new ResponseEntity<Enquiry>(enq,HttpStatus.OK);
		}
		else {
			log.error("No Enquiry found for Cibile Check...");
			return new ResponseEntity<Enquiry>(HttpStatus.OK);
		}
	
		
	}

}

