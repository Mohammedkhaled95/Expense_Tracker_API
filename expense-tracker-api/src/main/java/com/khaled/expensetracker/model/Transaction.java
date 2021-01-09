package com.khaled.expensetracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	
	@Column(name = "userId")
	private Long userId;
	
	
	@Column(name = "amount")
	private Double amount;
	
	
	@Column(name = "note")
	private String note;
	
	
	
	@Column(name = "transactionDate")
	private Long transactionDate;
//fetch = FetchType.EAGER,
	@ManyToOne( optional = false)
	@JoinColumn(name = "categoryId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore
	private Category category;



	public Transaction() {
	}
	
	






	public Transaction(Integer id, Long userId, Double amount, String note, Long transactionDate,
			Category category) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
		this.category = category;
	}








	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}






	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public Long getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(Long transactionDate) {
		this.transactionDate = transactionDate;
	}






	public Category getCategory() {
		return category;
	}






	public void setCategory(Category category) {
		this.category = category;
	}






	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", amount=" + amount + ", note=" + note
				+ ", transactionDate=" + transactionDate + ", category=" + category + "]";
	}




	
	
	
	
	
	
	
	
}
