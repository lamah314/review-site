package org.wecancodeit.reviewsite.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Size(min = 2, max = 30)
	private String name;

	@NotNull
	@Size(min = 2, max = 30)
	private String password;
	
	public User() {}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public Long getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}


}
