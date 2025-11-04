public class CreditCardPayment extends CardPayment implements Discount{
    public double creditLimit;
    public double discountedAmount;

    public CreditCardPayment(Double amount,String currency,String status,String cardNumber,String cardHolderName,String expiryDate, double creditLimit){
        super(amount, currency, status, cardNumber, cardHolderName, expiryDate);
        this.creditLimit = creditLimit;
        this.discountedAmount = amount;
    }

    @Override
    public void processPayment(){
        if(validate()) {
            System.out.println();
            System.out.println("Charging credit card with limit " + this.creditLimit + " for amount " + this.discountedAmount);
            markAsCompleted();
        }else {
            System.out.println();
            System.out.println("Payment failed: Invalid card number or expiry date....");
            status = "FAILED";
        }
    }

    public void applyInterest(){
        System.out.println("Applying interest if payment is not settled by due date");
    }

    @Override
    public double applyDiscount(double percent) {

        discountedAmount = amount * (1 - percent/100);
        return discountedAmount;
    }

    @Override
    public double finalAmount() {
        return discountedAmount;
    }
}
