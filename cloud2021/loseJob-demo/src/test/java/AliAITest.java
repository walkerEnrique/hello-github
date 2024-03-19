import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AliAITest {

    // 编写斐波拉切数列
    public static void main(String[] args) {

        main1();
        //
    }

    public static void main1(String... args){
        List<String> list = ImmutableList.of("20240315","Holls","这是一个测试类");
        List<String> list2 = new ArrayList<>();
        list2.add("Holls");
        List testList = list2.stream().filter(strin -> strin.contains("Holls")).collect(Collectors.toList());

        testList.forEach(s-> System.out.println(s));
    }



}
