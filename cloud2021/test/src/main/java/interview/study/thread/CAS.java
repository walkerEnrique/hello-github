package interview.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

//简单的自旋锁
public class CAS {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrcement(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current+1;
        }while(!atomicInteger.compareAndSet(current,next));
        System.out.println("***第几次访问：" +next);
        return next;
    }

    public static void main(String[] args) {
        new CAS().getAndIncrcement();
    }
}
