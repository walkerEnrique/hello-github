package interview.study.thread;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable
{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run()
    {
        synchronized (lockA)
        {
            //sleep3秒
            try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"\t 尝试持有: "+lockB);
            synchronized (lockB)
            {
                //sleep3秒
                try{TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t自己持有："+lockB+"尝试持有: "+lockA);
            }
        }
    }
}

public class DeadLockDemo
{
    public static void main(String[] args)
    {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBB").start();
    }

}
