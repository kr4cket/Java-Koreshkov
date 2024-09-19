package com.app.models.employers;

import com.app.enums.CompanyType;
import com.app.models.bank.BankAccount;

public class Company extends Employee {
    private String companyName;
    private CompanyType type;

    public Company(long id, String email, String phone, String address, BankAccount bankAccount, String companyName, CompanyType type) {
        super(id, email, phone, address, bankAccount);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
