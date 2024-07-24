package com.g3.hotel_g3_back.customer.domain;

public class Customer {
    private Integer idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer idPersonalData;

    public Customer(Integer idCustomer, Integer idPersonalData, String firstName, String lastName, String email, String phoneNumber) {
        this.idCustomer = idCustomer;
        this.idPersonalData = idPersonalData;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdPersonalData() {
        return idPersonalData;
    }

    public void setIdPersonalData(Integer idPersonalData) {
        this.idPersonalData = idPersonalData;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}