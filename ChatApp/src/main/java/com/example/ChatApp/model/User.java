package com.example.ChatApp.model;

public class User {

	  private String userName;

	  private String userMessage;

	  public User() {
	  }

	  public User(String userName,String userMessage) {
		  this.userMessage=userMessage;
		  this.userName=userName;
	  }
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	@Override
	public String toString() {
		return "Greeting [userName=" + userName + ", userMessage=" + userMessage + "]";
	}

	 

	}