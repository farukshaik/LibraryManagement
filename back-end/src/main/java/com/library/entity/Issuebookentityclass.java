package com.library.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book_trans")
public class Issuebookentityclass {

	@Id
	@Column(name = "trans_id")
	private int transId;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "roll_number")
	private Signupentityclass userRoleEntity;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ISBN")
	private SearchEntityclass bookEntity;

	@Column(name = "issued_by")
	private String issuedBy;

	@Column(name = "issued_date")
	private String issuedDate;

	@Column(name = "estimated_due_date")
	private String estimatedDueDate;

	@Column(name = "submitted_date")
	private String submittedDate;

	@Column(name="no_of_renewals")
	private Integer noOfRenewals;
	
	@Column(name="status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNoOfRenewals() {
		return noOfRenewals;
	}

	public void setNoOfRenewals(Integer noOfRenewals) {
		this.noOfRenewals = noOfRenewals;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public Signupentityclass getUserRoleEntity() {
		return userRoleEntity;
	}

	public void setUserRoleEntity(Signupentityclass userRoleEntity) {
		this.userRoleEntity = userRoleEntity;
	}

	public SearchEntityclass getBookEntity() {
		return bookEntity;
	}

	public void setBookEntity(SearchEntityclass bookEntity) {
		this.bookEntity = bookEntity;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getEstimatedDueDate() {
		return estimatedDueDate;
	}

	public void setEstimatedDueDate(String estimatedDueDate) {
		this.estimatedDueDate = estimatedDueDate;
	}

	public String getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}

}
