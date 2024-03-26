package interview.study.algorithm;

import java.util.HashMap;
import java.util.Map;

/*
    小青蛙跳台阶，可以一次跳一阶，也可以一次跳两阶，问跳上n阶一共有多少种跳法；
    问题拆分：
        跳上10阶，可以从第8阶跳两阶跳上去，也可以从第9阶跳一阶跳上去
        那么：f(10) = f(9) + f(8);
            f(9) = f(8) + f(7);
            .....
     可以用递归，但是空间复杂度和时间复杂度都不太行，可以尝试使用动态规划。。
     备忘录形势。穷举分析，确定边界，找到最有子结构，确定状态转换方程。
 */
public class FrogJumpAlgorithm {

    public static void main(String[] args) {
        FrogJumpAlgorithm frogJumpAlgorithm = new FrogJumpAlgorithm();
        Integer fibonacciNumber = frogJumpAlgorithm.getFibonacciNumber(10);
        fibonacciNumber = frogJumpAlgorithm.getFrogJumpCount(10);
        System.out.println(fibonacciNumber);
    }

    public int getFibonacciNumber(int n){
        Map<Integer,Integer> mapAlreadyExistValue = new HashMap<Integer,Integer>();
        if(n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }
        // 定义一个map，能够像备忘录一样记录已经计算过的值

        if(mapAlreadyExistValue.containsKey(n)){
            return mapAlreadyExistValue.get(n);
        }
        else{
            mapAlreadyExistValue.put(n,(getFibonacciNumber(n-1) + getFibonacciNumber(n-2)) % 1000000007 );
            return mapAlreadyExistValue.get(n);
        }

    }

    /*
    真的服了：就像绕口令一样。
        穷举分析
        确定边界
        找到最优子结构
        确定状态转移方程
     另外更好的方法解决青蛙跳的问题
     */
    public Integer getFrogJumpCount(Integer n){
        if(n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }
        // a为只有一个台阶的跳法，b为有两个台阶的跳法
        Integer a = 1, b = 2, temp = 0;

        for (int i = 3; i <= n; i++) {
            // 这一步好理解，前两步之和是第三步
             temp = (a + b) % 1000000007;
             // 后边的台阶给前边（因为所有的后一步的台阶都是前边的跳法之和，这边就将第二步的台阶赋值给第一步
             a = b;
             // 三阶的就给到了只有两阶的
             b = temp;
        }
        // 返回最后一步台阶的所有跳法
        return temp;
    }



}
