package interview.study.algorithm;

import java.util.List;

//双端锁单例模式
class Singleton{
    private volatile Singleton singleton = null;

    private Singleton getSingleton(){
        if(singleton == null)
        {
            synchronized (Singleton.class)
            {
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

public class InterviewCode {

    public static void main(String[] args) {

    }

    //一亿随机数排序
    public List<Integer> OneHundredsMillionSort(List<Integer> s){


        return null;
    }

    //多匹马跑，每一匹马跑完，记录（打印）时间，马匹跑完重新开跑

    //RPC方式通过socket编程实现

}
