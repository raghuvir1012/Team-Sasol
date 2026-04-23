//@author robertk
package com.teamsasol.banking.system;

public class SavingsAccount extends BankAccount {
    private final double minimumBalance;
    
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double minimumBalance) {
        super(accountNumber, ownerName, initialBalance);
        this.minimumBalance = minimumBalance;
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount Must be Greater than 0!");
        }
        if (getBalance() - amount < minimumBalance) {
            throw new InsufficientFundsException("You have Insufficient Funds for this Withdrawal!");
        }
        deductFromBalance(amount);
        getTransactions().add(new Transaction("Withdrawal", amount));
    }
    
    public double getMinimumBalance() {
        return minimumBalance;
    }
    
    @Override
    public String toString() {
        return "Account Type: Savings Account" 
        + "\nAccount Number: " + getAccountNumber()
        + "\nOwner Name: " + getOwnerName()
        + "\nCurrent Balance: " + getBalance()
        + "\nMinimum Balance: " + minimumBalance;
    }
}
