package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.SearchEntityclass;
import com.library.service.SearchServiceclass;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SearchControllerclass {

	@Autowired
	SearchServiceclass sc;

	@GetMapping(value = "/getBookDetailsByName")

	public @ResponseBody List<SearchEntityclass> getService(@RequestParam(name = "bookName") String bookName) {

		return sc.getBooks(bookName);
	}

}
