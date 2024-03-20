package interview.study.algorithm;

import java.util.List;
import java.util.concurrent.*;

public class InterviewCode{

    private volatile InterviewCode instance = null;

    /**
     * 创建4个屏障，处理完后执行run方法
     */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    /**
     * 假设有4匹马，设置线程池常驻线程数为4
     */
    private ExecutorService executor = new ThreadPoolExecutor(4,
            10,
            800L,
            TimeUnit.MICROSECONDS,
            new LinkedBlockingDeque<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 放入每匹马，线程名称和所用的时间
     */
    private ConcurrentHashMap<String,Long> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        new InterviewCode().runHorse();

    }

    //双端锁
    private InterviewCode getInstance(){

        if(instance == null)
        {
            synchronized (InterviewCode.class)
            {
                if(instance == null)
                {
                    instance = new InterviewCode();
                }
            }
        }
        return instance;
    }

    //一亿随机数排序
    private List<Integer> OneHundredsMillionSort(List<Integer> s){


        return null;
    }

    //多匹马跑，每一匹马跑完，记录（打印）时间，马匹跑完重新开跑
    private void runHorse() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Thread(() -> {
                //计算当前马（线程）跑的时间
                Long begin = System.currentTimeMillis();
                System.out.println("这是： " + Thread.currentThread().getName() + "在跑");
                Long end = System.currentTimeMillis();
                map.put(Thread.currentThread().getName(), end - begin);
                //马（线程）跑完了设置一个屏障
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }));
        }

    }
}
    //RPC方式通过socket编程实现
//    private void


