package interview.study.algorithm;

import java.util.Arrays;

public class OneHundredMillionsSort {

    public static void main(String[] args) {
        //给一个亿排序
        int[] oneHundredMillionsNumber = new int[100000000];

        for (int i = 0; i < 100000000; i++){
            oneHundredMillionsNumber[i] = (int)(Math.random()*100);
        }

        long beforeTime = System.currentTimeMillis();

        radix(oneHundredMillionsNumber);

        long afterTime = System.currentTimeMillis();

        System.out.println("used time"+(afterTime - beforeTime));

    }

    // 科大讯飞生成的一个亿的数字排序，也不知到对不对，先抄下来再说；
    // 叫什么基数排序法，我看就是二分发排序；
    private static void radix(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        int[] bucketList;
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            bucketList = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mod) / div;
                bucketList[num]++;
            }
            for (int j = 1; j < bucketList.length; j++) {
                bucketList[j] += bucketList[j - 1];
            }
            int[] temp = new int[arr.length];
            for (int j = arr.length - 1; j >= 0; j--) {
                int num = (arr[j] % mod) / div;
                temp[--bucketList[num]] = arr[j];
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = temp[j];
            }
        }
    }

}
