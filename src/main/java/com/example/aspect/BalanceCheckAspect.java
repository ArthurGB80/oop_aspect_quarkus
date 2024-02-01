package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import com.example.banking.BankAccount;
import com.example.banking.InsufficientFundsException;

@Aspect
public class BalanceCheckAspect {

    @Before("execution(* com.example.banking.*.withdraw(..)) && args(amount)")
    public void checkBalance(JoinPoint joinPoint, double amount) throws Throwable {
        Object target = joinPoint.getTarget();
        if (target instanceof BankAccount) {
            BankAccount account = (BankAccount) target;
            if (account.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds");
            }
        }
    }
}