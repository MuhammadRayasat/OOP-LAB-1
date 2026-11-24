// Lab Task 5: Runtime Polymorphism — Payment System
// Demonstrates:
//   - Inheritance: CashPayment, CardPayment and OnlinePayment extend Payment.
//   - Method overriding: each child class redefines pay().
//   - Runtime polymorphism: a parent-class reference calls pay(), and Java
//     decides AT RUNTIME which child version to run, based on the actual
//     object — not the reference type.

class Payment {
    void pay(double amount) {
        System.out.println("Processing generic payment of Rs " + amount);
    }
}

class CashPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Cash Payment: Rs " + amount
                + " received in cash. Receipt issued.");
    }
}

class CardPayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Card Payment: Rs " + amount
                + " charged to card. Transaction approved.");
    }
}

class OnlinePayment extends Payment {
    @Override
    void pay(double amount) {
        System.out.println("Online Payment: Rs " + amount
                + " transferred via online banking. Confirmation sent.");
    }
}

public class Main {
    public static void main(String[] args) {
        // One parent-class reference, three different child objects.
        Payment payment;

        payment = new CashPayment();
        payment.pay(5000);          // CashPayment's pay() runs

        payment = new CardPayment();
        payment.pay(12000);         // CardPayment's pay() runs

        payment = new OnlinePayment();
        payment.pay(8500);          // OnlinePayment's pay() runs

        // Same idea with an array of parent references.
        System.out.println("\n--- Payments via parent-class array ---");
        Payment[] payments = { new CashPayment(), new CardPayment(), new OnlinePayment() };
        double[] amounts = { 2000, 15000, 7000 };
        for (int i = 0; i < payments.length; i++) {
            payments[i].pay(amounts[i]);
        }
    }
}
