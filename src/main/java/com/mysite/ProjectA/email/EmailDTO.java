package com.mysite.ProjectA.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailDTO {
	
	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email address")
	private String email; 

}
