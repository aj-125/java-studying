
import java.util.ArrayList;
import java.util.List;

public class Wallet implements WalletInterface{
    private double balance;
    private List<Double> history = new ArrayList<>();

    @Override
    public double getBalance(){
        return this.balance;
    }

    @Override
    public void setBalance(double balance){
        this.balance = balance;
        this.history.add(balance);
    }

    @Override
    public List<Double> getHistory(){
        return this.history;
    }

    public Wallet(double balance){
        this.balance = balance;
        this.history.add(balance);
    }

    @Override
    public String purchase(double price){
        if(price <= balance){
            balance = balance - price;
            this.history.add(balance);

            return "Your payment was successful. balance is :  " + this.balance;
        }
        return "Your payment was not successful";
    }

    @Override
    public String income(double income){
            balance = balance + income;
            this.history.add(balance);

            return "You have recieved an income successful, balance is : " + this.balance;
    }

}