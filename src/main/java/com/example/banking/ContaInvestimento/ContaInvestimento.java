package com.example.banking.ContaInvestimento;

import com.example.banking.BankAccount;
import com.example.banking.InsufficientFundsException;

public class ContaInvestimento implements BankAccount {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        // The withdraw method should not contain the balance check logic
        // since it will be handled by the BalanceCheckAspect
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}