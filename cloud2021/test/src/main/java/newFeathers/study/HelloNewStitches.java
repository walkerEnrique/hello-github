package newFeathers.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class HelloNewStitches {

    public void main(String[] args) {

        // 这玩意用封装类还不好使。。
        List<String> list = new ArrayList<String>(){{add("1");}};
        // 删除元素的方法，好用，但是还有更好用的
        list.stream().filter(this::notNeedDel).collect(Collectors.toList());
        // 他说这个更好用
        list.removeIf(this::notNeedDel);

        // 用流来打印集合什么的
        list.stream().forEach(System.out::println);

        // 创建协程，就是虚拟线程，看不太懂。。
        Thread threads = Thread.startVirtualThread(()->{
            list.stream().map(i -> i + i).forEach(System.out::println);
        });
        Executors.newVirtualThreadPerTaskExecutor();

        ConcurrentHashMap<Object, Object> s = new ConcurrentHashMap<>();
    }

    // 主线程main中的static还不行，真的奇怪了，必须给去掉
    private boolean notNeedDel(String str){
        // 这里写判断集合中数据是否被去掉的逻辑
        return true;
    }

}
