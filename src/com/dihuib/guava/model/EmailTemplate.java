package com.dihuib.guava.model;

import javax.annotation.Nullable;

public class EmailTemplate {

	private String name;
	@Nullable
	private String email;

	public EmailTemplate(String email) {
		super();
		this.email = email;
	}

	public EmailTemplate(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailTemplate [name=" + name + ", email=" + email + "]";
	}
	
	

}
