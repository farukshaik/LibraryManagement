package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Issuebookentityclass;
import com.library.entity.Signupentityclass;

@Repository
public interface Issuebookrepoclass extends JpaRepository<Issuebookentityclass, Integer> {
	
	public List<Issuebookentityclass> findByUserRoleEntity(Signupentityclass sec);
	
	public Issuebookentityclass findByTransId(Integer trans_id);
	
	public List<Issuebookentityclass> findAllByStatus(String status);
	

}
