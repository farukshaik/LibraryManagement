package com.library.otherclasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.library.entity.Issuebookentityclass;
import com.library.repository.Issuebookrepoclass;
import com.library.repository.SearchRepoclass;
import com.library.repository.Signuprepoclass;
import com.library.service.EmailService;

@Component
public class Scheduler {

	@Autowired
	Issuebookrepoclass ibrc;

	@Autowired
	EmailService es;

	@Autowired
	Signuprepoclass src;

	@Autowired
	SearchRepoclass serc;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Scheduled(fixedRate = 1000 * 60 * 60 * 24)
	public void sendScheduler() {

		try {
			Issuebookentityclass ibec = new Issuebookentityclass();

			List<Issuebookentityclass> al = ibrc.findAllByStatus("active");

			Date date = new Date();
			for (Issuebookentityclass issuebookentityclass : al) {
				String dueDate = issuebookentityclass.getEstimatedDueDate();
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				String currentTime = sdf.format(date);
				Date dDate = sdf.parse(dueDate);
				Date tDate = sdf.parse(currentTime);
				long diffInMillies = Math.abs(tDate.getTime() - dDate.getTime());
				long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);

				if (diffInDays == 1) {
					es.sendMail(src.findByRollNo(issuebookentityclass.getUserRoleEntity().getRollNo()).getEmail(),
							"Book renewal remainder",
							"Heyy" + "," + " "
									+ src.findByRollNo(issuebookentityclass.getUserRoleEntity().getRollNo())
											.getStudentName()
									+ "\n" + "It's time to renew your book" + " "
									+ serc.findByIsbn(issuebookentityclass.getBookEntity().getIsbn()).getBookName()
									+ "." + " " + "Hurry up before you miss the due date." + "\n" + "Thank you.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
