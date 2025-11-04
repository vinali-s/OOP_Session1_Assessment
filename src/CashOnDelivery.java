public class CashOnDelivery extends Payment{
    public String deliveryAddress;

    public CashOnDelivery(Double amount,String currency,String status,String deliveryAddress){
        super(amount, currency, status);
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public void processPayment(){
        if(validate()) {
            System.out.println();
            System.out.println("Cash will be collected at delivery address: " + this.deliveryAddress);
            markAsCompleted();
        }else {
            System.out.println();
            System.out.println("Payment failed: Check the delivery address....");
            status = "FAILED";
        }
    }

    @Override
    public boolean validate() {
        return deliveryAddress != null && !deliveryAddress.isEmpty();
    }
}
