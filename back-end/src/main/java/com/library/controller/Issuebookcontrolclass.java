package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Issuebookmodelclass;
import com.library.service.Issuebookserviceclass;

@RestController
public class Issuebookcontrolclass {

	@Autowired
	Issuebookserviceclass isc;

	@PostMapping(value = "/issueBook")

	public void getService(@RequestBody Issuebookmodelclass ibmc) {
		isc.getService(ibmc);
	}

}
