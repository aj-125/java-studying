import java.util.List;

public interface WalletInterface {
    double getBalance();                   // getter للرصيد
    void setBalance(double balance);       // setter للرصيد
    List<Double> getHistory();             // getter للتاريخ القديم (قائمة الرصيد بعد كل عملية)
    String purchase(double price);         // عملية الشراء (خصم من الرصيد)
    String income(double income);   
}
