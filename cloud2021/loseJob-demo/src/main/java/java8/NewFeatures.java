package java8;

import java8.entity.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewFeatures {

    public static void main(String[] args) {

        //流式编程；
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.forEach(n -> System.out.println(n));

        list.forEach(System.out::println);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(11, "小牙刷", 12.05 ));
        items.add(new Item(5, "日本马桶盖", 999.05 ));
        items.add(new Item(7, "格力空调", 888.88 ));
        items.add(new Item(17, "肥皂", 2.00 ));
        items.add(new Item(9, "冰箱", 4200.00 ));
        //执行移除id为7的Item
        items.removeIf(ele -> ele.getNumber() == 7);

        //通过 foreach 遍历，查看是否已经删除
//        items.forEach(System.out::println);

        //集合内排序；
        //old-fashion
//        items.sort(new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return o1.getNumber() - o2.getNumber();
//            }
//        });
        // new-fashion
        items.sort(((o1, o2) -> o1.getNumber() - o2.getNumber()));
        items.forEach(System.out::println);





    }



}
