public class DebitCardPayment extends CardPayment implements Discount{
    public double availableBalance;
    public double discountedAmount;

    public DebitCardPayment(Double amount,String currency,String status,String cardNumber,String cardHolderName,String expiryDate,double availableBalance){
        super(amount, currency, status, cardNumber, cardHolderName, expiryDate);
        this.availableBalance = availableBalance;
        this.discountedAmount = amount;
    }

    @Override
    public void processPayment(){
        if(validate()) {
            System.out.println();
            System.out.println("Debiting from account balance " + this.availableBalance + " for amount " + this.discountedAmount);
            markAsCompleted();
        }else{
            System.out.println();
            System.out.println("Payment failed: Invalid card number or expiry date....");
            status = "FAILED";
        }
    }

    public void checkSufficientBalance(){
        System.out.println("Checking if balance covers amount");
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
