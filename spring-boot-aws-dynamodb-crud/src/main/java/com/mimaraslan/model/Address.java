package com.mimaraslan.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	private String addressLine1;
	private String addressLine2;
	private String state;
	private String city;
	private String zipCode;

	@DynamoDBAttribute
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@DynamoDBAttribute
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@DynamoDBAttribute
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@DynamoDBAttribute
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@DynamoDBAttribute
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}