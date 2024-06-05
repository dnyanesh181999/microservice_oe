package com.cjc.loanapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.model.EmailForSendingEnquiryToOE;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.SendEmailOetoCustomer;
@Service
public class EmailOeToCustomer implements SendEmailOetoCustomer{
@Autowired
JavaMailSender jms;

@Override
public void sendEmailOeToCustomer(Enquiry eq,EmailForSendingEnquiryToOE dm) {
	SimpleMailMessage  email=new SimpleMailMessage();
	String subject="Loan Status";
	String text1="Dear ,\r\n"+eq.getEnquiryName()
			+ "\r\n"
			+ "Thank you for applying for a loan with [Star Finance Limited]. After reviewing your application, we regret to inform you that we cannot approve your loan at this time.\r\n"
			+ "\r\n"
			+ "If you have any questions or need further assistance, please contact us at [7038543806] or [mail2shubhamkalokhe04@gmail.com].\r\n"
			+ "\r\n"
			+ "We appreciate your understanding.\r\n"
			+ "\r\n"
			+ "Best regards,\r\n"
			+ "\r\n"
			+ "[Star Finance Limited]";
	String text2="Dear\r\n"+eq.getEnquiryName()+","
			+ "We are pleased to inform you that your loan application with [Star Finance Limited] has been approved!\r\n"
			+ "\r\n"
			+ "Our team will contact you shortly to discuss the next steps and finalize the details. If you have any questions in the meantime, please feel free to reach out to us at [7038543806] or [mail2shubhamkalokhe04@gmail.com].\r\n"
			+ "\r\n"
			+ "Thank you for choosing [Star Finance Limited]. We look forward to serving you.\r\n"
			+ "\r\n"
			+ "Best regards,\r\n"
			+ "\r\n"
			+ "Star Finance Limited";
	
	
	
	email.setSubject(subject);
	if(eq.getRemark().equals("Approved")) {
		email.setText(text2);
	}
	if(eq.getRemark().equals("Rejected")) {
		email.setText(text1);
	}
	email.setTo(eq.getEmail());
	jms.send(email);
	
}


}
