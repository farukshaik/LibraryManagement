package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.SearchEntityclass;

@Repository
public interface SearchRepoclass extends JpaRepository<SearchEntityclass, Integer> {

	public List<SearchEntityclass> findByBookNameIgnoreCaseContaining(String bookName);
	
	public SearchEntityclass findByIsbn(String isbn);
	


}
