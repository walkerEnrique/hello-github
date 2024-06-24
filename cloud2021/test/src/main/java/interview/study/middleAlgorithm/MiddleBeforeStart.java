package interview.study.middleAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MiddleBeforeStart {

    public static void main(String[] args) {

        MiddleBeforeStart mid = new MiddleBeforeStart();
        List<List<String>> list = mid.partition("1221566");
        //
        for (int i = 0; i < list.size(); i++) {
            list.get(i).stream().forEach(System.out::println);
        }
        // 这打印出来的是地址，不好使。。
//        list.stream().map(List::listIterator).forEach(System.out::println);
    }

    // 鸡蛋从楼层掉落，已知楼的层数n，f是鸡蛋掉落就回碎的具体楼层，且0<=f<=n，现在求f和最少多少次
    // 能够试出来f的值
    private int superEggDrop(int k,int n){
        // 估计是动态规划之类的
        // 倒是动态规划，可是也有点看不懂啊，不管了，抄答案
        // m不会超过N次的线性扫描
        int[][] dp = new int[k+1][n+1];
        int m = 0;
        while(dp[k][m] < n){
            m++;
            for (int i = 0; i < k; i++) {
                dp[i][m] = dp[i-1][m] + dp[i-1][m-1] + 1;
            }
        }
        return m;
    }

    // 给定字符串，将s分割成一些字串，使每个字串都是回文串，返回所有可能的组合
    // 这个题不太会，直接G，题解没有问题，人的问题；
    private List<List<String>> partition(String s){
        // 首先咱们把所有的可能的字串先找出来，然后验证所有的回文字符串，把字符串放进去就行了
        // 说的简单，谁不会说一样，talk is cheap，show me the code；
        List<List<String>> lists = new ArrayList<>();
        // 先分串
        backTracking(s,0,new ArrayList<>(),lists);
        return lists;
    }

    private void backTracking(String s, int index, ArrayList<String> list, List<List<String>> result) {
        // 判断传入的index是否等于list长度，等于就直接返回list；
        if(index == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        // 从index到s的长度进行循环，判断是否是回文串，然后递归调用该方法，反复的判断下
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // 添加子串
                list.add(s.substring(index, i + 1));
                // 递归调用回串
                backTracking(s, i + 1, list, result);
                // 移除list集合最后一位
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,Integer left,Integer right){
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return left>=right;
    }
}
