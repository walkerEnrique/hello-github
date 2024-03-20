package interview.study.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumTwo {

    public static void main(String[] args)
    {
        Integer[] array1 = new Integer[]{2,7,11,15};
        int[] array2 = {2,7,11,15};
        int target = 9;
        for(int element : sumTwoOne(array1,target)){
            System.out.println(element);
        }
//        System.out.println(sumTwoTwo(array,target));
    }

    //在一个数组当中,找目标
    public static int[] sumTwoOne(Integer[] array,int target)
    {
        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(array));
        for(int i=0;i<arrayList.size();i++) {
            int subtraction = target - arrayList.get(i);
            if(arrayList.contains(subtraction)){
                return new int[]{arrayList.indexOf(subtraction),i};
            }
        }
       return null;
    }

    public static int[] sumTwoTwo(int[] array,int target)
    {
        Map<Object,Integer> map = new HashMap<Object, Integer>();
        for(int i=0;i<array.length;i++) {
            int subtraction = target -array[i];
            if(map.containsKey(subtraction)){
                return new int[]{map.get(subtraction),i};
            }
            map.put(array[i],i);
        }
        return null;
    }
}
