package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.entity.Signupentityclass;
import com.library.model.Signupmodelclass;
import com.library.repository.Signuprepoclass;

@Service
public class Signupserviceclass {

	@Autowired
	Signuprepoclass src;

	@Autowired
	EmailService es;

	public void addStudent(Signupmodelclass smc) {
		System.out.println(smc);
		Signupentityclass sec = new Signupentityclass();
		sec.setStudentName(smc.getStudentName());
		sec.setRollNo(smc.getRollNumber());
		sec.setPassword(new BCryptPasswordEncoder().encode(smc.getPassword()));
		sec.setDept(smc.getDepartment());
		sec.setEmail(smc.getEmail());
		sec.setMobile(smc.getMobile());
		sec.setRank("5");
		sec.setRole("student");
		src.save(sec);
		
		es.sendMail(smc.getEmail(),
				"Registration Successful",
				"Heyy"+" "+ smc.getStudentName()+","+"you are successfully registered at University of Hyderabad Library."
				+ "Now, you can login through your credentials. Thank you.");
	}

}
