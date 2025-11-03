import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public static void main(String[] args) {
        CashOnDelivery COD = new CashOnDelivery(1000.00, "LKR", "PENDING", "no 5,main road,colombo");
        BankTransfer BT = new BankTransfer(1500.00, "LKR", "COMPLETED", "BOC", "13264978", "444555");
        CreditCardPayment CreditPay = new CreditCardPayment(45500.00, "LKR", "FAILED", "16453242", "W.P.Perera", "2029.10.14", 10000.00);
        DebitCardPayment DebitPay = new DebitCardPayment(3000.00, "LKR", "PENDING", "4652357", "D.H.Senadeera", "2022.12.12", 8500.00);

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

        for (Payment p : payments) {
            p.processPayment();
            p.generateReceipt();
            System.out.println("***************");
        }


    }

