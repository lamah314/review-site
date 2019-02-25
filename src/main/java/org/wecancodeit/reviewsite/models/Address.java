package org.wecancodeit.reviewsite.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	private String streetAddress;
	private String cityAddress;
	private String stateAddress;
	private String zipAddress;

	@OneToMany(mappedBy = "address")
	private Collection<User> users;

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public String getStateAddress() {
		return stateAddress;
	}

	public String getZipAddress() {
		return zipAddress;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public Address() {
	}

	public Address(String streetAddress, String cityAddress, String stateAddress, String zipAddress) {
		super();
		this.streetAddress = streetAddress;
		this.cityAddress = cityAddress;
		this.stateAddress = stateAddress;
		this.zipAddress = zipAddress;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress=" + streetAddress + ", cityAddress=" + cityAddress
				+ ", stateAddress=" + stateAddress + ", zipAddress=" + zipAddress + "]";
	}

}
