package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="register")
@Table(name = "register")
public class Users {

	@Column(name = "username")
	private String username;
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "confirmpassword")
	private String confirmpassword;
	@Column(name = "contact")
	private int contact;
	@Column(name = "gender")
	private String gender;

	public Users() {

	}

	public Users(String username, String email, String password, String confirmpassword, int contact, String gender) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.contact = contact;
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", email=" + email + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", contact=" + contact + ", gender=" + gender + "]";
	}

}
