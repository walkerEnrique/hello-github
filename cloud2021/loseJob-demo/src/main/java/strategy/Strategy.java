package strategy;

import java.util.HashMap;
import java.util.Map;

public class Strategy implements IPaymentStrategy {
    @Override
    public void pay(double amount) {

    }

    public static class CreditCardPay implements IPaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("信用卡支付"+amount);
        }
    }

    public static class WechatPay implements IPaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("微信支付"+amount);
        }
    }

    public static class Main{
        public static void main(String[] args){
            IPaymentStrategy strategy = new CreditCardPay();
            PaymentContext context = new PaymentContext(strategy);
            context.pay(2.00);

            strategy = new WechatPay();
            context = new PaymentContext(strategy);
            context.pay(20.0);

            //策略模式优化,可以取消context类
            Map<String, IPaymentStrategy> map = new HashMap<String, IPaymentStrategy>();
            map.put("CREDIT_PAY", new CreditCardPay());
            map.put("WECHAT_PAY", new WechatPay());

            map.get("WECHAT_PAY").pay(20.0);


            //枚举优化策略模式代码
            Map<String,PaymentStrategyEnum> mapEnum = new HashMap<String, PaymentStrategyEnum>();
            mapEnum.put("WECHAT_PAY", PaymentStrategyEnum.WECHAT_PAYMENT);
            mapEnum.put("CREDIT_PAY", PaymentStrategyEnum.CREDIT_PAYMENT);


        }

    }
}


