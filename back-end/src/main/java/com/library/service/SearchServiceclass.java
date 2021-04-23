package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.SearchEntityclass;
import com.library.repository.SearchRepoclass;

@Service
public class SearchServiceclass {

	@Autowired
	SearchRepoclass repo;

	public List<SearchEntityclass> getBooks(String bookName) {
		List<SearchEntityclass> al = repo.findByBookNameIgnoreCaseContaining(bookName);
		return al;
	}

}
