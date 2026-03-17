package mynato_ver3;

public class MomoPayment implements EWalletPayable {

    @Override
    public void processMoMo(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount + " - Thành công");
    }
}
