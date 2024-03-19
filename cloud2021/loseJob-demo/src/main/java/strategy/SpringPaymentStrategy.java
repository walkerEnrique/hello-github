package strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public class SpringPaymentStrategy implements IStrategySpringTest {

    @Override
    public void print(String name) {

    }

    // 假定这个是一个A策略
    @Service("TestA")
    @Slf4j
    public class TestA implements IStrategySpringTest {
        @Override
        public void print(String name){
            log.info("");
        }

    }

    // 这是一个B策略
    @Service("TestB")
    @Slf4j
    public class TestB implements IStrategySpringTest {
        @Override
        public void print(String name){
            log.info("");
        }

    }


}
