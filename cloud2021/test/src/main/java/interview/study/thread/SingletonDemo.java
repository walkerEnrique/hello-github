package interview.study.thread;

//DCL（Double check lock）双端锁实现
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t constructor method");
    }

    public static SingletonDemo getInstace(){
        if(instance == null){
            synchronized(SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                SingletonDemo.getInstace();
//                System.out.println(Thread.currentThread().getName()+"\t name is");
            },String.valueOf(i)).start();
        }

    }
}
