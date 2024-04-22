package interview.study.algorithm.DesignQuestions;

import java.util.Random;

public class Solution {

    // Standard Performance Answer
    int[] nums;
    int[] original;

    public void Solution(int[] nums){
        // 初始化数组
        this.nums = nums;
        this.original = new int[nums.length];
        // 这一段好像是复制数组，不太确定，再看看
        System.arraycopy(nums, 0, original, 0,nums.length);

    }

    // 重新设置数组，比如以前的数组是{1，2，3}，这个方法过后显示的数字也是{1，2，3}
    public int[] reset(){
        System.arraycopy(original,0,nums,0,nums.length);
        return nums;
    }

    public int[] shuffle(){
        Random random = new Random();
        // 循环给随机下角标给新的数组
        for (int i = 0; i < nums.length; ++i) {
            // 这一段是重置下角标
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * your Solution will be instantiated and called as such:
     * Solutions obj = new Solution(nums);
     * int[] params_1 = obj.getReset();
     * int[] params_2 = obj.getShuffle();
     */
}
