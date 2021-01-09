package com.khaled.expensetracker.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    List<Category> categories ;
    
    
    
    public UserDao() {
	}

	/*
    @Column(name = "first_name")
    private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
*/
    
    
    
    
	public String getUsername() {
        return username;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDao(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}

