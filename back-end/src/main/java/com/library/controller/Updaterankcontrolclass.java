package com.library.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.Updaterankserviceclass;

@RestController
public class Updaterankcontrolclass {

	@Autowired
	Updaterankserviceclass ursc;         

	@PostMapping(value = "/updateRank")

	public String getService(@RequestBody String rollNumber) throws ParseException {

		return ursc.getService(rollNumber);
	}
}
