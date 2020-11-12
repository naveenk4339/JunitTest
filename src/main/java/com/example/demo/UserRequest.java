package com.example.demo;

public class UserRequest {
    private  String lastName;
    
	public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    private  String firstName;

    public UserRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
