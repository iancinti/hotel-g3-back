package com.g3.hotel_g3_back.booking.domain;

import java.sql.Date;

public class Booking {
    private int id;
    private int idCustomer;
    private int idPayment;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(int id, int idCustomer, int idPayment, Date checkInDate, Date checkOutDate) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.idPayment = idPayment;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}