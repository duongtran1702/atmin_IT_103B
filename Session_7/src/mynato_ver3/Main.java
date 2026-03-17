package mynato_ver3;

public class Main {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.payCOD(new CODPayment(), 500000);

        processor.payCard(new CreditCardPayment(), 1000000);

        processor.payMoMo(new MomoPayment(), 750000);
    }
}
