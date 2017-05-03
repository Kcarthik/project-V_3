package com.niit.MuscleMechanic.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class BillingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "please enter the apartmentnumber ")
	private String apartmentNumber;
	@NotEmpty(message = "please enter the streetname")
	private String streetName;
	@NotEmpty(message = "please enter the city")
	private String city;
	@NotEmpty(message = "please enter the state")
	private String State;
	@NotEmpty(message = "please enter the country")
	private String country;
	@NotEmpty(message = "please enter the zipcode")
	private String zipcode;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "BillingAddress [id=" + id + ", apartmentNumber=" + apartmentNumber + ", streetName=" + streetName + ", city= " + city + ", State=" + State+ ", Country= "+ country +" ,Zipcode= "+zipcode+"]";
	}

}
