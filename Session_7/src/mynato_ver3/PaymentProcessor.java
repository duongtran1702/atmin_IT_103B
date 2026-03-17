package mynato_ver3;

public class PaymentProcessor {

    public void payCOD(CODPayable payment, double amount) {
        payment.processCOD(amount);
    }

    public void payCard(CardPayable payment, double amount) {
        payment.processCreditCard(amount);
    }

    public void payMoMo(EWalletPayable payment, double amount) {
        payment.processMoMo(amount);
    }
}
