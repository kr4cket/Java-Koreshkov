package com.app.models.bank;

public class BankAccount {
    private String iban;
    private String bic;
    private String accountHolder;

    public BankAccount(String iban, String bic, String accountHolder) {
        this.iban = iban;
        this.bic = bic;
        this.accountHolder = accountHolder;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }
}
