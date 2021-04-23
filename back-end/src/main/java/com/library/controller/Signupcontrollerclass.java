package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Signupmodelclass;
import com.library.service.Signupserviceclass;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class Signupcontrollerclass {

	@Autowired
	Signupserviceclass sc;

	@PostMapping(value = "/addStudent")
	public void getService(@RequestBody Signupmodelclass mc) {
		
		sc.addStudent(mc);

	}
}
