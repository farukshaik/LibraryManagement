package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.entity.Issuebookentityclass;
import com.library.repository.Issuebookrepoclass;
import com.library.repository.Signuprepoclass;

@Service
public class Getstudentbooksserviceclass {

	@Autowired
	Issuebookrepoclass ibrc;
	
	@Autowired
	Signuprepoclass src;
	
	public List<Issuebookentityclass> getService(String rollNumber)
	{
	List<Issuebookentityclass> al = ibrc.findByUserRoleEntity(src.findByRollNo(rollNumber));
	return al;
	}
}
