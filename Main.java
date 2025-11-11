import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter you Balance: ");
        Scanner input = new Scanner(System.in);
        double balance= input.nextDouble(); 

        WalletInterface kamalsWallet = new Wallet(balance);

        for(int x = 0; x < 5; x++){
            System.out.println("Please enter a payment: ");
            double payment= input.nextDouble(); 
            System.out.println(kamalsWallet.purchase(payment));

            System.out.println("Please enter an income: ");
            double income= input.nextDouble(); 
            System.out.println(kamalsWallet.income(income));
        }

        System.out.println(kamalsWallet.getBalance());
        System.out.println("your payment history is : " + kamalsWallet.getHistory());
    }
}