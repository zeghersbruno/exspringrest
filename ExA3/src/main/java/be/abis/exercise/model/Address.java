package be.abis.exercise.model;

import javax.validation.constraints.NotBlank;

public class Address {
	
	private String street;
	@NotBlank(message="Town cannot be empty")
	private String town;
	private String zipcode;
	private int nr;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}

	

}
