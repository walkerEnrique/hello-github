package interview.study.thread;

import interview.study.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException
    {
        CountDownLatch countDownLatch = new CountDownLatch(7);

        //循环创建线程
        for (int i = 1; i <= 7; i++)
        {
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"\t 被灭了");
//                countDownLatch.countDown();
//            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 统一了");
        System.out.println(Integer.MAX_VALUE);
    }

    public static void closeDoor() throws InterruptedException{
        //循环创建10个线程
        for (int i = 0; i < 6; i++) {
                    new Thread(()->{
                        System.out.println(Thread.currentThread().getName()+"\t 被干掉");
                },String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName()+"\t 统一了");

    }

}
