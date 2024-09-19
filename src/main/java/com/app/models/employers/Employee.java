package com.app.models.employers;

import com.app.models.bank.BankAccount;

public class Employee {
    private final long id;
    private String email;
    private String phone;
    private String address;
    private BankAccount bankAccount;

    public Employee(long id, String email, String phone, String address, BankAccount bankAccount) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.bankAccount = bankAccount;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

}
