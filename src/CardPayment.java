public class CardPayment extends Payment{
    public String cardNumber;
    public String cardHolderName;
    public String expiryDate;

    public CardPayment(Double amount,String currency,String status,String cardNumber,String cardHolderName,String expiryDate){
        super(amount,currency,status);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(){
        System.out.println("Authorizing card payment for " + this.cardHolderName + "...");
    }

    public void validateCard(){
        System.out.println("Validating card number format...");
    }

    @Override
    public boolean validate() {
        return cardNumber != null && cardNumber.length() >= 12 && expiryDate != null;
    }
}
