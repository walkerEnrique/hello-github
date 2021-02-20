package interview.study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwllock = new ReentrantReadWriteLock();
    private ReentrantLock reentrantLock = null;

    void put(String key, Object value){
        rwllock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try{TimeUnit.MICROSECONDS.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwllock.writeLock().unlock();
        }


    }

    public void get(String key){
        rwllock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取"+key);
            try{TimeUnit.MICROSECONDS.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
            Object v = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+v);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwllock.readLock().unlock();
        }

    }

}

public class ReadWriteLockDemo {

    public static void main(String[] args){

        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt);
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }

    }
}
