package banking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 ticket #2: Implement the Transaction class
 this class is immutable to ensure the audit trail cannot be tampered with
 */
public class Transaction {

    // enum for transaction types
    public enum Type {
        DEPOSIT, WITHDRAWAL
    }

    private final Type type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime timestamp;

    // constructor - sets timestamp automatically
    public Transaction(Type type, double amount, double balanceAfter) {
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }

    // getters for all fields
    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        // formatter to match the required format: [YYYY-MM-DD HH:mm]
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDate = timestamp.format(formatter);
        
        // using String.format to ensure currency looks correct (2 decimal places)
        return String.format("[%s]  %-10s  R %8.2f   Balance: R %8.2f", 
                formattedDate, 
                type, 
                amount, 
                balanceAfter);
    }
}
