public class CashOnDelivery extends Payment{
    public String deliveryAddress;

    public CashOnDelivery(Double amount,String currency,String status,String deliveryAddress){
        super(amount, currency, status);
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public void processPayment(){
        System.out.println();
        System.out.println("Cash will be collected at delivery address: " + this.deliveryAddress);
        markAsCompleted();
    }

    @Override
    public boolean validate() {
        return deliveryAddress != null && !deliveryAddress.isEmpty();
    }
}
