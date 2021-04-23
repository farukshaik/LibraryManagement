package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.Libsubmitbookserviceclass;

@RestController
public class Libsubmitbookcontrolclass {

	@Autowired
	Libsubmitbookserviceclass lsbsc;

	@GetMapping(value = "/libSubmitBook")

	public @ResponseBody void getService(@RequestParam(name = "transId") Integer transId) {
		lsbsc.getService(transId);
	}
}
