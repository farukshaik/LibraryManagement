package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.service.Librenewserviceclass;

@RestController
public class Librenewbookcontrolclass {

	@Autowired
	Librenewserviceclass lrsc;
	
	@GetMapping(value="/libRenewBook")
	public @ResponseBody void getService(@RequestParam(name="transId") Integer transId)
	{
		lrsc.getService(transId);
	}
}
