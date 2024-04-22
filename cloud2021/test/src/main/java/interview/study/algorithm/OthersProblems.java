package interview.study.algorithm;

import java.util.List;

public class OthersProblems {

    public static void main(String[] args) {

        OthersProblems prog = new OthersProblems();
        System.out.println(prog.hammingWeight(2147483645));

    }

    // 编写一个函数，以二进制的方式输入，返回其二进制设置位的个数（也成为汉明重量）
    private int hammingWeight(int n){

        // 只需要数一的个数就行了，直接原始方法取整除，然后到一结束；
        return Integer.bitCount(n);
    }

    // 汉明距离：两个数字对应二进制不同位置的数目
    private int hammingDistance(int x, int y){
        // 抄答案，找的规律，虽然我也不知道咋回事
        // 但是能出来就行，其实还是找规律的问题，比如异或，和不同的数目异或就是0还是1，忘记了
        // 然后与运算等等。。
        int z = x ^ y;
        int distance = 0;
        while(z != 0){
            distance++;
            z = z & (z-1);
        }
        return distance;
    }

    // 颠倒二进制位
    private int reverseBits(int n){
        // you need treat n as an unsigned value;
        // 把n转换二进制，然后顺序倒过来就行了，
        // 估计也是用异或或者与什么的操作


        return 1;
    }

    // 杨辉三角
    // 给定前边多少行，返回前边几行的值
    private List<List<Integer>> generate(int numRows){

        // 肚子有点饿了。。
        return null;
    }

    // 有效的括号
    // 满足
    // 1、左边的括号必须用相同的右边括号闭合
    // 2、左括号必须以正确的顺序闭合
    // 3、每个右括号必须有相同类型的左括号闭合
    private boolean isValid(String s){

        return false;
    }

    //缺失数字，吗的这个怎么这么长，是不是压轴题目？
    // 给定一个包含[0,n]的数组，找出没有出现在[0,n]中的那个数
    private int missingNumber(int[] nums){

        return 1;
    }

}
