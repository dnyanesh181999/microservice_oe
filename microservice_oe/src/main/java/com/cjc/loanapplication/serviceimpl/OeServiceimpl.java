package com.cjc.loanapplication.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.NoResourceFoundException;
import com.cjc.loanapplication.model.EmailForSendingEnquiryToOE;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.repository.OeRepository;
import com.cjc.loanapplication.servicei.OeServicei;
import com.cjc.loanapplication.servicei.SendEmailOetoCustomer;
import com.cjc.loanapplication.utility.CibilScore;
@Service
public class OeServiceimpl implements OeServicei {
@Autowired
OeRepository oserve;
@Autowired
SendEmailOetoCustomer mailToCustomer;
@Override
public List<Enquiry> getAllFtoe() {
	List<Enquiry>list=oserve.findAllByRemark("FTOE");
	if(!list.isEmpty()) {
		return list;
	}
	else {
		throw new NoResourceFoundException("Their is No FTOE.....Remark Enquirie");
	}
	
}


@Override
public Enquiry checkCibil(Enquiry e, Integer enquiryId, EmailForSendingEnquiryToOE email) {
	Optional<Enquiry> opt = oserve.findById(enquiryId);
	if(opt.isPresent()) {
		Enquiry enq =opt.get();
		enq.setCibilScore(CibilScore.cibilScore());
		if(enq.getCibilScore()>=720) {
			enq.setRemark("Approved");
			mailToCustomer.sendEmailOeToCustomer(enq ,email);
		}
		else {
			enq.setRemark("Rejected");
			mailToCustomer.sendEmailOeToCustomer(enq ,email);
		}
		Enquiry e1=oserve.save(enq);
		return e1;
	}
	else {
		throw new NoResourceFoundException("Their is No Enquiry For This Id...");
	}
}

	

	

}