package com.library.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Issuebookentityclass;
import com.library.model.Issuebookmodelclass;
import com.library.repository.Issuebookrepoclass;
import com.library.repository.SearchRepoclass;
import com.library.repository.Signuprepoclass;

@Service
public class Issuebookserviceclass {

	@Autowired
	Issuebookrepoclass ibrc;

	@Autowired
	Signuprepoclass src;

	@Autowired
	SearchRepoclass serc;

	@Autowired
	EmailService es;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public void getService(Issuebookmodelclass ibmc) {

		Issuebookentityclass ibec = new Issuebookentityclass();

		ibec.setUserRoleEntity(src.findByRollNo(ibmc.getRollNumber()));

		ibec.setBookEntity(serc.findByIsbn(ibmc.getIsbn()));

		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 15); // Adding 5 days String output =
		String dueTime = sdf.format(c.getTime());
		String currentTime = sdf.format(date);
		Integer renewals = 0;
		ibec.setIssuedDate(currentTime);
		ibec.setEstimatedDueDate(dueTime);
		ibec.setNoOfRenewals(renewals);
		ibec.setStatus("active");
		serc.findByIsbn(ibmc.getIsbn()).setStatus("not available");
		ibrc.save(ibec);
		es.sendMail(src.findByRollNo(ibmc.getRollNumber()).getEmail(), "Book issued successfully", "Heyy" + "," + " "
				+ src.findByRollNo(ibmc.getRollNumber()).getStudentName() + "\n" + "Your request for the book" + " "
				+ serc.findByIsbn(ibmc.getIsbn()).getBookName() + " " + "is processed succesfully." + " "
				+ "In future, you can login to the portal to renew your books before due date." + "\n" + "Thank you.");

	}
}
