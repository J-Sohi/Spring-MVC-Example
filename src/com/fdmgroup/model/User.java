package com.fdmgroup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="JPA_USER")
@DiscriminatorColumn(name="user_type", discriminatorType=DiscriminatorType.STRING, length=20)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
	@NamedQuery(name="user.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="user.findByUsername", query="SELECT u FROM User u WHERE u.username LIKE :uname"),
})
public class User {
	
	@Id
	@Column(name="user_id", length=6)
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Column(nullable = false, unique=true, length=30)
	private String username;
	
	@NotEmpty
	@Column(name="pw", nullable=false, length = 30)
	private String password;
	
	@Column(nullable=false)
	private String firstname;
	
	@Column(nullable=false)
	private String lastname;
	
//	@Column(columnDefinition = "Number(1)")
//	private boolean active;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String firstname, String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;		
//		this.active = true;
	}

//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}

}
