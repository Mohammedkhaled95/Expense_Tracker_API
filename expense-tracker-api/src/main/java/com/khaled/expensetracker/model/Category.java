package com.khaled.expensetracker.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="category")
public class Category {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	 //  after refactoring
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private UserDao user;

	
	

    @OneToMany(mappedBy = "category")
    List<Transaction> transactions ;
    
    
    
    
	/*
	@Column(name = "userId")
	private Integer userId;
	*/
	
	@Column(name = "title")
    private String title;
	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "totalExpense")
	private Double totalExpense;
	
	
	
	
	
	public Category() {
		}




/*
	public Category(Integer id, Integer userId, String title, String description, Double totalExpense) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.totalExpense = totalExpense;
	}





	@Override
	public String toString() {
		return "Category [id=" + id + ", userId=" + userId + ", title=" + title + ", description=" + description
				+ ", totalExpense=" + totalExpense + "]";
	}

	
	public Integer getUserId() {
		return userId;
	}
	
	
	
	
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
*/

	


	public Integer getId() {
		return id;
	}





	public Category(Integer id, UserDao user, String title, String description, Double totalExpense) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.description = description;
		this.totalExpense = totalExpense;
	}




	@Override
	public String toString() {
		return "Category [id=" + id + ", user=" + user + ", title=" + title + ", description=" + description
				+ ", totalExpense=" + totalExpense + "]";
	}




	public UserDao getUser() {
		return user;
	}




	public void setUser(UserDao user) {
		this.user = user;
	}




	public void setId(Integer id) {
		this.id = id;
	}









	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Double getTotalExpense() {
		return totalExpense;
	}





	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}


	
	
	
	
}
