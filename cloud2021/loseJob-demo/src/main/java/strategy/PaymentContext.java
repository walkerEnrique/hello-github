package strategy;

/*
    创建上下文类
 */
public class PaymentContext {
    private IPaymentStrategy paymentStrategy;
    public PaymentContext(IPaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public void pay(Double amount){
        paymentStrategy.pay(amount);
    }

}


