package com.example.banking;

public class ContaCorrente implements BankAccount {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}