import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        CashOnDelivery COD = new CashOnDelivery(1000.00, "LKR", "PENDING", "123 Main Street");
        BankTransfer BT = new BankTransfer(15000.00, "LKR", "PENDING", "BOC", "13264978", "REF5555");
        CreditCardPayment CreditPay = new CreditCardPayment(4500.00, "USD", "PENDING", "1111-2222-3333-4444", "W.P.Perera", "12/27", 50000.00);
        DebitCardPayment DebitPay = new DebitCardPayment(3000.00, "LKR", "PENDING", "5555-6666-7777-8888", "D.H.Senadeera", "06/26", 25000.00);

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
        payments.add(COD);
        payments.add(BT);
        payments.add(CreditPay);
        payments.add(DebitPay);

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

