package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Issuebookentityclass;
import com.library.service.Getstudentbooksserviceclass;

@RestController
public class Getstudentbookscontrollerclass {

	
	@Autowired
	Getstudentbooksserviceclass gsbsc;
	
	@GetMapping(value="/getBooks")
	
	public @ResponseBody  List<Issuebookentityclass> getService(@RequestParam (name="rollNumber") String rollNumber)
	{
		return gsbsc.getService(rollNumber);
	}
}
