package lock;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

class MyData
{
    volatile int number = 0;

    public void addT60()
    {
        number = 60;
    }

    public void addPlusPlus()
    {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic()
    {
        atomicInteger.getAndIncrement();
    }

}

/**
 * 1、验证可见性
 *  1.1 number = 0前没有加volatile关键字修饰，没有可见性
 *  1.2 加上volatile保证可见性
 */
public class VolatileDemo {

    public static void main(String[] args) {

        MyData myData = new MyData();//资源类

        HashMap<String,String> hashMap = new HashMap<>();

//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName()+"\t :come in");
//            // 暂停线程
//            try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
//            myData.addT60();
//            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
//        },"AAA").start();
//
//        while(myData.number == 0){
//            // 停在这儿
//        }
//
//        System.out.println(Thread.currentThread().getName()+"\t the mission is over!");

        for(int i = 1; i <= 10; i++){
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        // 等待上边20个线程跑完后，看main的最后结果值是多少
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+"\t the final number name :"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t the final number name :"+myData.atomicInteger);

    }
}
