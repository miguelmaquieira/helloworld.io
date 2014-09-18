package com.helloworldio.front.web.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component("signupUser")
public class SignupUser extends SignUser {
	
	private static final long serialVersionUID = -425741209549906597L;
	
	@NotNull(message="{common.form.field.empty.error}")
	@NotEmpty(message="{common.form.field.empty.error}")
	@Size(max=100, min=0, message="{common.form.field.length.error}")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
