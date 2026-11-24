// Lab Task 4: Method Overriding — Banking System
// Demonstrates:
//   - Inheritance: SavingsAccount and CurrentAccount extend Account.
//   - Method overriding: both child classes redefine displayAccountInfo()
//     with behavior specific to their account type.

class Account {
    String accountNumber;
    String holderName;
    double balance;

    Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Common method: each account type overrides it.
    void displayAccountInfo() {
        System.out.println("Account -> No: " + accountNumber
                + ", Holder: " + holderName + ", Balance: Rs " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate; // annual interest rate in percent

    SavingsAccount(String accountNumber, String holderName,
                   double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountInfo() {
        double yearlyInterest = balance * interestRate / 100;
        System.out.println("Savings Account -> No: " + accountNumber
                + ", Holder: " + holderName + ", Balance: Rs " + balance
                + ", Interest Rate: " + interestRate + "%"
                + ", Yearly Interest: Rs " + yearlyInterest);
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountNumber, String holderName,
                   double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void displayAccountInfo() {
        System.out.println("Current Account -> No: " + accountNumber
                + ", Holder: " + holderName + ", Balance: Rs " + balance
                + ", Overdraft Limit: Rs " + overdraftLimit
                + " (no interest is paid on current accounts)");
    }
}

public class Main {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("SA-1001", "Ali Raza", 50000, 8.5);
        Account current = new CurrentAccount("CA-2001", "Sara Malik", 75000, 25000);

        // Same method call, different behavior per object (overriding).
        savings.displayAccountInfo();
        current.displayAccountInfo();

        // Parent-class array holding different child objects.
        System.out.println("\n--- All accounts (parent references) ---");
        Account[] accounts = { savings, current };
        for (Account account : accounts) {
            account.displayAccountInfo();
        }
    }
}
