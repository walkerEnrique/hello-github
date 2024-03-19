package strategy;

import jdk.internal.instrumentation.Logger;

public enum PaymentStrategyEnum {
    CREDIT_PAYMENT {
        @Override
        public void pay(Double amount){
            Logger log = null;
            log.info("信用卡支付"+amount);
            // 具体支付逻辑
        }
    },
    WECHAT_PAYMENT {
        @Override
        public void pay(Double amount){
            Logger log = null;
            log.info("微信支付"+amount);
            // 具体支付逻辑
        }
    };

    public abstract void pay(Double amount);
}
