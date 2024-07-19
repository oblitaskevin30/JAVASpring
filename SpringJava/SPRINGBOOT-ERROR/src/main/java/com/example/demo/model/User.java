package com.example.demo.model;

public class User {
	private Long id;
	private String name;
	private String lasName;
	private Role role;
	public User(Long id, String name, String lasName) {
		super();
		this.id = id;
		this.name = name;
		this.lasName = lasName;
	}
	public User() {

	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLasName() {
		return lasName;
	}
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
	public String getRoleName() {
		return role.getName();
	}

	
	
}
