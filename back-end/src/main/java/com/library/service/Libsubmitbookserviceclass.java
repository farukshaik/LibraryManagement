package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Issuebookentityclass;
import com.library.repository.Issuebookrepoclass;
import com.library.repository.SearchRepoclass;

@Service
public class Libsubmitbookserviceclass {

	@Autowired
	Issuebookrepoclass ibrc;

	@Autowired
	EmailService es;
	
	@Autowired
	SearchRepoclass src;
	
	public void getService(Integer transId)
	{
		Issuebookentityclass ibec =   ibrc.findByTransId(transId);
		
		src.findByIsbn(ibec.getBookEntity().getIsbn()).setStatus("available");
		ibec.setStatus("submitted");
		ibrc.save(ibec);
		es.sendMail(ibrc.findByTransId(transId).getUserRoleEntity().getEmail(), "Book submission successfull", "Heyy" + "," + " "
				+ ibrc.findByTransId(transId).getUserRoleEntity().getStudentName() + "\n" + "Your request to submit book" + " "
				+ ibrc.findByTransId(transId).getBookEntity().getBookName() + " " + "is processed succesfully." + "\n"
				+ "Thank you.");

		
	}
}
