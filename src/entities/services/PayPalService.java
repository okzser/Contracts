package entities.services;

public class PayPalService implements OnlinePaymentService {

    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public Double paymentFee(double amount) {
        return amount * PAYMENT_FEE;
    }

    @Override
    public Double interest(double amount, int months) {
        return amount * months * MONTHLY_INTEREST;
    }
}
