package interview.study.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class OthersProblems {

    public static void main(String[] args) {

        OthersProblems pro = new OthersProblems();
        List<List<Integer>> list = pro.generate(6);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j).toString()+" ");
            }
            System.out.println();
        }
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
        // 杂七杂八的异或与运算，看不太懂，一般这种看不懂的我是不会写的，就是这么硬气！
        // 总的来说就是从大（16位）互相移动，到（8位）互相移动交换位置，直到最后一位相互交换；

        // 还是背答案吧，真，最后一道题
        // 定义结果
        int res = 0;
        // 循环重置位数
        for (int i = 0; i < 32;i++){
            // res向左移动一位，用来存放n的最后一位数
            res<<=1;
            //  把n的右边的最后一位数放入有res中，累加一下，看不懂，但我大为震撼！
            res+=n & 1;
            // 再把n向右边移动一位，最后一位数字去掉
            n>>=1;
        }
        return res;
    }

    // 杨辉三角
    // 给定前边多少行，返回前边几行的值
    private List<List<Integer>> generate(int numRows){

        // 这个知道规律，具体怎么实现，待研究
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 这是每一行的遍历
        for (int i = 0; i < numRows; i++) {
            // 这是第一行的下角标和对应的数据
            list.add(0,1);
            // 第二行的数据呢
            // 因为每行的数据都比之前的数据的下角标多一格，所以咱们这儿的循环从1开始，最后因为以1结束
            // 所以循环的终点比行数循环要少一，这里是需要list的size的，直接用numRow是不行的
            for (int j = 1; j < list.size() - 1; j++) {
                // 这里还用了set方法，等下去看看这个方法是干嘛的
                list.set(j, list.get(j)+list.get(j+1));
            }
            // 这里还直接new了个新的list，为嘛呀，等下有空再看看？估计是没空
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    // 有效的括号
    // 满足
    // 1、左边的括号必须用相同的右边括号闭合
    // 2、左括号必须以正确的顺序闭合
    // 3、每个右括号必须有相同类型的左括号闭合
    private boolean isValid(String s){

        // 压栈
        // 为什么这么做呢，我也不知道，因为我抄的答案；
        Stack<Character> stack = new Stack<Character>();
        char[] c = s.toCharArray();
        for(char ch : c){
            if(ch=='['){
                stack.push(']');
            }else if(ch=='('){
                stack.push(')');
            }else if(ch=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != ch){
                // 如果栈为空，或者栈顶元素不是这个啥，就不是对称的
                // 这里插一句，如果是peek，就是获取栈底的元素
                return false;
            }
        }
        return stack.isEmpty();
    }

    // 给定一个包含[0,n]的n位数组nums，找出没有出现在范围[0,n]中的那个数
    private int missingNumber(int[] nums){
        // 还是用异或那一套解
        // 自己和自己异或等于0
        // 任何数字和0异或还是等于它自己
        // 异或运算具有交换性

        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            // i不是个下角标吗，这为嘛，，不管了，最后一道题，再说
            xor^= nums[i]^(i+1);
        }
        return xor;
    }

}
