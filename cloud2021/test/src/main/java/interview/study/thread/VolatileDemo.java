package interview.study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int num = 0;

    public void addT060()
    {
        this.num = 60;
    }

    public void add(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void atomicAdd(){
        atomicInteger.getAndIncrement();
    }
}

public class VolatileDemo
{
    public static void main(String[] args){
        atomVolatile();
    }
    public static void atomVolatile(){
        MyData myData = new MyData();

        for(int i=0;i<20;i++){
            new Thread(()->{
                for(int j = 0;j < 1000;j++){
                    myData.add();
                    myData.atomicAdd();
                }
            }, String.valueOf(i)).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t processing,num value is: "+myData.num);
        System.out.println(Thread.currentThread().getName()+"\t processing,atomicInteger value is: "+myData.atomicInteger);

    }

    public static void seeVolatileOK(String[] args)
    {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            //暂停线程
            try{TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){e.printStackTrace();}
            myData.addT060();
            System.out.println(Thread.currentThread().getName()+"\t change value:"+myData.num);
            },"AAA").start();

        while(myData.num == 0){
            //main线程就一直在这等待，直到不是0
        }
        System.out.println(Thread.currentThread().getName()+"\t is over,value is: "+myData.num);
    }
}
