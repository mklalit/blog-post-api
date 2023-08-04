package com.lalitblog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 4,message = "Username must greater than 4 characters!")
	private String name;

	@Email(message = "Email address not valid!!")
	private String email;

	@NotEmpty
	private String password;

	@NotEmpty
	private String about;
}
