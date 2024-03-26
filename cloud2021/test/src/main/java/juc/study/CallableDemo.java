package juc.study;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable
{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*************come in Callable");
        //sleep3秒
        try{
            TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}


public class CallableDemo
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());

        Thread t1 = new Thread(futureTask,"AA");
        t1.start();
        System.out.println(Thread.currentThread().getName()+"**********");
        int result01 = 100;
        int result02 = futureTask.get();
        System.out.println("********result"+(result01+result02));

        // 多线程生成


    }


}
