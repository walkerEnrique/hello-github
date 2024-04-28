package interview.study.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Mathematical {

    public static void main(String[] args) {

        Mathematical mat = new Mathematical();
        System.out.println(mat.romanToInt("MCMXCIV"));
    }

    // 返回FizzBuzz的集合，如果是3或者3的倍数返回fizz，5或者5的倍数返回buzz，同时是3和5的倍数，返回FizzBuzz；
    private List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            // 先判断下是否是3和5一起的倍数
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    // 给定整数n，返回所有小于非负整数n的质数的数量
    private int countPrimes(int n) {
        // 埃拉托斯特尼筛选法（Eratosthenes），不是递归调用一个方法，把质数的倍数去掉后全是质数了
        // 初始所有的都为true
        boolean[] arr = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (arr[i]) continue;
            // 不是初始的质数的倍数那么就是质数了
            count++;
            for (int j = i; j < n; j += i) {
                // 是质数的倍数，那么就不是质数
                arr[j] = true;
            }
        }
        return count;
    }

    // 给定一个整数，写一个函数判断它是否是3的幂次方，如果是返回true，不是返回false；
    private boolean isPowerOfThree(int n) {

        if (n > 1) {
            // 递归先试一下，
            while (n % 3 == 0) {
                n /= 3;
            }
        }
        return n == 1;
    }

    // 罗马数字转整数
    private int romanToInt(String s) {

        // 字符          数值
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        int sum = 0;
        // 前一个数字表示的值
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // 如果前边大小比后边的小那么，他俩就得相减
            // 刚刚是确定边界值错了，现在是求和了
            int num = getValue(s.charAt(i));
            // 他吗的这里也有坑，自己的问题，不好意思啦
            if (preNum < num) {
                // 直接减就行了，想这么多干嘛。。
                sum -= preNum;
            } else {
                sum += preNum;
            }
            // 这里赋值是为了求和的
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


}
