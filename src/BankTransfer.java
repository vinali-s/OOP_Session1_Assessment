public class BankTransfer extends Payment{
    public String bankName;
    public String accountNumber;
    public String referenceCode;

    public BankTransfer(Double amount,String currency,String status,String bankName,String accountNumber,String referenceCode){
        super(amount, currency, status);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.referenceCode = referenceCode;
    }

    @Override
    public void processPayment(){
        if(validate()) {
            System.out.println();
            System.out.println("Initiating bank transfer to " + this.bankName + " using account " + this.accountNumber + " with reference " + this.referenceCode);
            markAsCompleted();
        }else {
            System.out.println();
            System.out.println("Payment failed: Invalid account number or bank name....");
            status = "FAILED";
        }
    }

    @Override
    public boolean validate() {
        return bankName != null && accountNumber != null && accountNumber.length() >= 6;
    }
}
