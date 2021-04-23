package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.Renewbookserviceclass;

@RestController
public class Renewbookcontrolclass {

	@Autowired
	Renewbookserviceclass rbsc;

	@GetMapping(value = "/renewBook")

	public @ResponseBody Integer getService(@RequestParam(name = "transId") int transId) {
		return rbsc.getService(transId);
	}

}
