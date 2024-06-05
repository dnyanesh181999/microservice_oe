package com.cjc.loanapplication.servicei;

import java.util.List;

import com.cjc.loanapplication.model.EmailForSendingEnquiryToOE;
import com.cjc.loanapplication.model.Enquiry;

public interface OeServicei {

	public List<Enquiry> getAllFtoe();

	public Enquiry checkCibil(Enquiry e, Integer enquiryId, EmailForSendingEnquiryToOE email);

	

}
