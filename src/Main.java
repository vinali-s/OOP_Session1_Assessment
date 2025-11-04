import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        CashOnDelivery COD1 = new CashOnDelivery(1000.00, "LKR", "PENDING", "123 Main Street");
        CashOnDelivery COD2 = new CashOnDelivery(1000.00, "LKR", "PENDING", "");
        BankTransfer BT1 = new BankTransfer(15000.00, "LKR", "PENDING", "BOC", "13264978", "REF5555");
        BankTransfer BT2 = new BankTransfer(15000.00, "LKR", "PENDING", "BOC", "1111", "REF5555");
        CreditCardPayment CreditPay1 = new CreditCardPayment(4500.00, "USD", "PENDING", "1111-2222-3333-4444", "W.P.Perera", "12/27", 50000.00);
        CreditCardPayment CreditPay2 = new CreditCardPayment(4500.00, "USD", "PENDING", "1111-2222-3333-4444", "W.P.Perera", "",50000.00);
        DebitCardPayment DebitPay1 = new DebitCardPayment(3000.00, "LKR", "PENDING", "5555-6666-7777-8888", "D.H.Senadeera", "06/26", 25000.00);
        DebitCardPayment DebitPay2 = new DebitCardPayment(3000.00, "LKR", "PENDING", "5555-6666-", "D.H.Senadeera", "06/26", 25000.00);

//        COD.processPayment();
//        BT.processPayment();
//        CreditPay.processPayment();
//        DebitPay.processPayment();
//
//        COD.generateReceipt();
//        BT.generateReceipt();
//        CreditPay.generateReceipt();
//        DebitPay.generateReceipt();

        List<Payment> payments = new ArrayList<>();
        payments.add(COD1);
        payments.add(COD2);
        payments.add(BT1);
        payments.add(BT2);
        payments.add(CreditPay1);
        payments.add(CreditPay2);
        payments.add(DebitPay1);
        payments.add(DebitPay2);

//        for (Payment p : payments) {
//            p.processPayment();
//            p.generateReceipt();
//            System.out.println("***************");
//        }

        for (Payable p : payments) {
            System.out.println("\nProcessing: " + p.getClass());
            System.out.println("Reference: " + p.getReference());
            System.out.println("Valid? " + p.validate());

            if (p instanceof Discount discount) {
                discount.applyDiscount(10); // 10% discount
                System.out.println("Discounted amount: " + discount.finalAmount());
            }

            if (p instanceof Payment payment) {
                payment.processPayment();
                payment.generateReceipt();
            }

            System.out.println("--------------------------------------------");
        }




    }
}

