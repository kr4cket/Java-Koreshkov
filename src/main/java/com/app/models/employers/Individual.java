package com.app.models.employers;

import com.app.models.bank.BankAccount;

public class Individual extends Employee {
    private String name;
    private String secondName;
    private boolean hasChildren;
    private int age;


    public Individual(long id, String email, String phone, String address, BankAccount bankAccount, String name, String secondName, boolean hasChildren, int age) {
        super(id, email, phone, address, bankAccount);
        this.name = name;
        this.secondName = secondName;
        this.hasChildren = hasChildren;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public int getAge() {
        return age;
    }
}
