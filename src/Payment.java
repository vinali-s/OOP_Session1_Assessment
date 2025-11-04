public abstract class Payment implements Payable {
    public Double amount;
    public String currency;
    public String status;
    public String referenceId;

    public Payment(Double amount, String currency, String status){
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.referenceId = "TXN-" + (int)(Math.random() * 100000);
    }

    public Double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getStatus() { return status; }
    public String getReferenceId() { return referenceId; }

    public void setAmount(Double amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setStatus(String status) { this.status = status; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

    // abstract method
    public abstract void processPayment();

    // Concrete method
    public void generateReceipt(){
        System.out.println("Receipt:");
        System.out.println("Reference: " + this.referenceId);
        System.out.println("Amount: " + this.amount + " " + this.currency);
        System.out.println("Status: " + this.status);
    }

    public void markAsCompleted(){
        this.status = "COMPLETED";
//        System.out.println("Payment marked as COMPLETED.");
    }

    @Override
    public String getReference() {
        return referenceId;
    }
}
