package lock;

public class SingleTon {

    private static volatile SingleTon instance = null;

    private SingleTon()
    {
        System.out.println(Thread.currentThread().getName()+":我是单例模式！");
    }

    public static SingleTon getInstance() {
        if (null == instance) {
            synchronized (SingleTon.class) {
                if(null == instance){
                    return instance = new SingleTon();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args)
    {
//        System.out.println(SingleTon.getInstance() == SingleTon.getInstance());
//        System.out.println(SingleTon.getInstance() == SingleTon.getInstance());
//        System.out.println(SingleTon.getInstance() == SingleTon.getInstance());

        for (int i = 1; i <= 10; i++)
        {
            new Thread(() -> {
                SingleTon.getInstance();
            },String.valueOf(i)).start();
        }
    }

}
