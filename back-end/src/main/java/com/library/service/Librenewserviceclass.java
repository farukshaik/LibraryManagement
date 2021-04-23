package com.library.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Issuebookentityclass;
import com.library.repository.Issuebookrepoclass;

@Service
public class Librenewserviceclass {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	Issuebookrepoclass ibrc;

	@Autowired
	EmailService es;
	
	public void getService(Integer transId) {
		Issuebookentityclass ibec = ibrc.findByTransId(transId);
		//String estimatedDueDate = ibrc.findByTransId(transId).getEstimatedDueDate();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 15);
		String newEstimatedDueDate = sdf.format(c.getTime());
		ibec.setUserRoleEntity(ibrc.findByTransId(transId).getUserRoleEntity());
		ibec.setBookEntity(ibrc.findByTransId(transId).getBookEntity());
		ibec.setEstimatedDueDate(newEstimatedDueDate);
		ibec.setIssuedDate(ibrc.findByTransId(transId).getIssuedDate());
		ibec.setNoOfRenewals(0);
		ibec.setStatus("active");
		ibrc.save(ibec);
		es.sendMail(ibrc.findByTransId(transId).getUserRoleEntity().getEmail(), "Book renewal successfull", "Heyy" + "," + " "
				+ ibrc.findByTransId(transId).getUserRoleEntity().getStudentName() + "\n" + "Your request to renew book" + " "
				+ ibrc.findByTransId(transId).getBookEntity().getBookName() + " " + "is processed succesfully." + "\n"
				+ "Updated due date : "+" "+ibrc.findByTransId(transId).getEstimatedDueDate()
				+ "Thank you.");


	}
}
