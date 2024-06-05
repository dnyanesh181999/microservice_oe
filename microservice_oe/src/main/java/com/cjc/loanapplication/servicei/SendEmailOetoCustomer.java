package com.cjc.loanapplication.servicei;

import com.cjc.loanapplication.model.EmailForSendingEnquiryToOE;
import com.cjc.loanapplication.model.Enquiry;

public interface SendEmailOetoCustomer {
public void sendEmailOeToCustomer(Enquiry eq,EmailForSendingEnquiryToOE mail);
}
