package com.brandonodom.bigtechcompanies.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	@NotEmpty(message="Email is required")
    @Email
    private String email;

    @NotEmpty(message="Password is required")
    @Size(max = 128)
    private String password;

    public LoginUser() {}

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
    

}
