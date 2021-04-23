package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Signupentityclass;
import com.library.repository.Signuprepoclass;

@Service
public class Retrievestudentdataservice {

	@Autowired
	public Signuprepoclass src;

	public Signupentityclass getStudentData(String rollNumber) {
		Signupentityclass al = src.findByRollNo(rollNumber);
		return al;
	}
}
