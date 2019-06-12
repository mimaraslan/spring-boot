package com.mimaraslan.modelmapper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String emailAddress;
    private String mobileNumber;
    private String city;

    public User(long id, String name, String emailAddress, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }

    public User(long id, String name, String emailAddress, String mobileNumber, String city) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}