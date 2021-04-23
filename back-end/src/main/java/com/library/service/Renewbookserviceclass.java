package com.library.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Issuebookentityclass;
import com.library.repository.Issuebookrepoclass;
import com.library.repository.SearchRepoclass;
import com.library.repository.Signuprepoclass;

@Service
public class Renewbookserviceclass {

	@Autowired
	Issuebookrepoclass ibrc;

	@Autowired
	EmailService es;
	
	@Autowired
	Signuprepoclass src;

	@Autowired
	SearchRepoclass serc;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Integer getService(int transId) {
        Issuebookentityclass ibec = ibrc.findByTransId(transId);
		
        String estimatedDueDate = ibrc.findByTransId(transId).getEstimatedDueDate();
		Integer noOfRenewals = ibrc.findByTransId(transId).getNoOfRenewals();
		// System.out.println(noOfRenewals);
		Calendar c = Calendar.getInstance();

		if ((estimatedDueDate.compareTo(Integer.toString(Calendar.DATE)) <= 0) && (noOfRenewals < 3)) {
			c.add(Calendar.DATE, 15);
			String newEstimatedDueDate = sdf.format(c.getTime());
			ibec.setUserRoleEntity(ibrc.findByTransId(transId).getUserRoleEntity());
			ibec.setBookEntity(ibrc.findByTransId(transId).getBookEntity());
			ibec.setEstimatedDueDate(newEstimatedDueDate);
			ibec.setIssuedDate(ibrc.findByTransId(transId).getIssuedDate());
			ibec.setNoOfRenewals(noOfRenewals + 1);
			ibec.setStatus("active");
			//System.out.println(ibec);
			ibrc.save(ibec);
			es.sendMail(ibrc.findByTransId(transId).getUserRoleEntity().getEmail(), "Book renewal successfull", "Heyy" + "," + " "
					+ ibrc.findByTransId(transId).getUserRoleEntity().getStudentName() + "\n" + "Your request to renew " + " "
					+ ibrc.findByTransId(transId).getBookEntity().getBookName() + " " + " book is processed succesfully." + "\n "
					+ "Updated due date is : " +" "+ibrc.findByTransId(transId).getEstimatedDueDate() + "\n"
					+ "Number of times renewed : " + " " + ibrc.findByTransId(transId).getNoOfRenewals() +"\n"
					+"Thank you.");

		}
return ibrc.findByTransId(transId).getNoOfRenewals();

	}

}
