package com.library.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Issuebookentityclass;
import com.library.entity.Signupentityclass;
import com.library.repository.Issuebookrepoclass;
import com.library.repository.Signuprepoclass;

@Service
public class Updaterankserviceclass {

	@Autowired
	Issuebookrepoclass ibrc;

	@Autowired
	Signuprepoclass src;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String getService(String rollNumber) throws ParseException {
		Date date = new Date();
		Signupentityclass sec = src.findByRollNo(rollNumber);

		List<Issuebookentityclass> ibec = ibrc.findByUserRoleEntity(sec);
		int rank = 0;
		String finalRank = "";
		int booksCount = 0;
		for (Issuebookentityclass issuebookentityclass : ibec) {
			String dueDate = issuebookentityclass.getEstimatedDueDate();
			String currentDate = sdf.format(date);
			Date dDate = sdf.parse(dueDate);
			Date cDate = sdf.parse(currentDate);
			if (issuebookentityclass.getStatus().equals("active")) {
				booksCount++;
				long diffInMillies = (cDate.getTime() - dDate.getTime());
				long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
				// System.out.println(diffInDays);
				if (diffInDays <= 2) {
					rank = rank + 5;
				} else if (diffInDays > 2 && diffInDays <= 5) {
					rank = rank + 4;
				} else if (diffInDays > 5 && diffInDays <= 10) {
					rank = rank + 3;
				} else if (diffInDays > 10 && diffInDays <= 20) {
					rank = rank + 2;
				} else {
					rank = rank + 1;
				}

			}
			if (booksCount > 0) {
				finalRank = Integer.toString(rank / booksCount);
				sec.setRank(finalRank);
				System.out.println(finalRank);
				src.save(sec);
			}
		}

		return finalRank;
	}
}
