package interview.study.algorithm;

import java.util.Stack;

public class DynamicProgramming {

    public static void main(String... args){

        DynamicProgramming d = new DynamicProgramming();
        int[] arrays = new int[]{1,-1,3,4,-2,2};
        System.out.println(d.maxSubarray(arrays));

        Stack stack = new Stack();
    }

    // 买卖股票的最佳时机
    // 股票是一天天变化的，根据历史信息统计在哪天买，哪天卖获利最大，如果股票天天跌就没必要算了
    private int maxProfit(int[] prices){
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        // 一次遍历
        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice,prices[i]);
            // 遍历之后，如果算出的利润大于现在已有的利润，则更新当前最大利润
            max = Math.max(max,prices[i] - minPrice);
        }
        return max;
    }

    // 返回最大子序和
    // 得到一个连续的数组，数组的和为最大，数组长度最小应该可以为1
    private int maxSubarray(int[] nums){

        // 确定状态
        // 找到转移公式
        // 确定初始条件及边界
        // 找到最佳结果
        // dp[i] = Math.max(dp[i-1],0) + nums[i];贪心算法
        int length = nums.length;
        // 确定初始值
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < length; i++) {
            // 找到转移公式，这里看不懂呀，但我大为震撼，，
            cur = Math.max(cur,0) + nums[i];
            // 记录最大值
            max = Math.max(max,cur);
        }
        return max;
    }

    // 打家劫舍
    // 专业的小偷，连续偷想邻的两户就会报警，现在是想要获最大的利益
    private int rob(int[] nums){

        // 还是动态规划的问题
        // 确定状态，找到转移公式
        // 找到初始条件和边界
        // 怎么确定状态-现在的状态是dp[i] + nums[i]；
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        // 第一家没偷
        int dp0 = 0;
        // 第一家偷了
        int dp1 = nums[0];
        // 从第二开始判断
        for(int i = 1;i<length;i++){
            int temp = Math.max(dp0,dp1);
            dp1 = dp0 + nums[i];
            dp0 = temp;
        }
        return Math.max(dp0,dp1);
    }
}
