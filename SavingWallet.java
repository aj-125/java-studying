import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
 
public class SavingWallet implements WalletInterface {
    private double balance;
    private List<Double> history = new ArrayList<>();
    private LocalDateTime lastPurchase;
 
    public SavingWallet(double balance) {
        this.balance = balance;
        this.history.add(balance);
    }
 
    @Override
    public double getBalance() {
        return this.balance;
    }
 
    @Override
    public void setBalance(double balance) {
        this.balance = balance;
        this.history.add(balance);
    }
 
    @Override
    public List<Double> getHistory() {
        return this.history;
    }
 
    @Override
    public String purchase(double price) {
        if(!validTimeToPurchase()) return  "❌ Payment failed. You must wait an Hour between each purchase.";
        if (price <= balance && price <= 20) {
            balance -= price;
            this.lastPurchase = LocalDateTime.now();
            this.history.add(balance);
            return "✅ Payment successful. Balance is: " + this.balance;
        }
        return "❌ Payment failed. Not enough balance.";
    }
 
    @Override
    public String income(double income) {
        balance += income;
        this.history.add(balance);
        return "💰 Income added successfully. Balance is: " + this.balance;
    }

    public boolean validTimeToPurchase(){
        if(lastPurchase == null){
            return true;
        }
        return LocalDateTime.now().isAfter(lastPurchase.plusHours(1));
    }
    
}