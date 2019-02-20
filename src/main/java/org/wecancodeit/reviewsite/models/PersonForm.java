package org.wecancodeit.reviewsite.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@Size(min = 2, max = 30)
	private String password;
	
	
	public PersonForm(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "PersonForm [name=" + name + ", password=" + password + "]";
	}


}
