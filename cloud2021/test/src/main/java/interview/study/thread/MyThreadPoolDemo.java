package interview.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @auther lrl
 * @create 2021-01-30 14.44
 */
public class MyThreadPoolDemo
{
    public static void main(String[] args)
    {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try
        {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
    public static void threadPoolinit()
    {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor = Executors.newCachedThreadPool();
        //模拟人来办理业务
        try
        {
            List<String> str = new ArrayList<String>();
            for (int i = 0; i < 5; i++) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
