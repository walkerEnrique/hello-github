package interview.study.algorithm;

import java.util.*;

public class BeforeBegin {

    public static void main(String[] args) {
//        int result = solutionTwo(new int[]{1,1,2,2,3});
//        int mostNum = majorityElement(new int[]{2,2,1,1,1,2,2});
//        boolean bool = findTarget(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},19);
//        System.out.println(bool);
//        int[] nums = mergeArray(new int[]{1, 2, 3, 0, 0}, 5, new int[]{4, 5}, 2);
//        for (int i : nums) {
//            System.out.println(i);
//        }
        System.out.println(reverseInteger(123450));
    }

    public static int myAsciiToInteger(String s){

        // 丢弃前边无用的前导空格
        // 确定字符是正的还是负的
        // 无论是哪的其余东西除了数字都要被忽略
        // 没有读入数据，则返回为零
        // 返回的整数有范围的就是int的范围啦，如果多了需要截取到范围的数

        // 总结：需求太多了，明天再弄吧

        return 1;
    }

    // 外观数列
    public static int countAndSay(int a){

        // 数列是对前一项的描述；for example；
        // 1，的后一项“一个1”
        // 11，的后一项“两个个1”
        // 21，的后一项“一个2，一个1”
        // 1211，的后一项“一个1，一个2，二个1”
        // 111221，的后一项“三个1，两个2，一个1”
        // 312211;

        // 规律找到了，怎么做呢，不晓得，看情况吧，嘻嘻嘻嘻嘻嘻

        return 1;
    }

    // 整数反转
    public static int reverseInteger(int a){

        int res= 0;
        while(a != 0){
            // 设定了一个值，初始化为0，对10做乘法，再对传入10取余，得到最后一位
            res = res * 10 + a % 10;
            // 为嘛要判断这俩相同不呢
            if(res % 10 != a % 10){
                return 0;
            }
            // 对10取整除，得到前边几位
            a /= 10;
        }

        return res;
    }
    //使用异或找到数组中不重复数字（*推荐*）
    public static int solutionOne(int[] arr) {
        int result = 0;
        for (Integer i : arr) {
            result ^= i;
        }
        return result;
    }

    //笨办法找不重复数字
    public static int solutionTwo(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        for (Integer s : set) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (s == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return s;
            }
        }
        return 0;
    }

    //笨办法找多数元素（>n/2）
    public static int mostNum(int[] nums) {

        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer count = hashMap.get(num);
            count = count == null ? 1 : ++count;
            hashMap.put(num, count);
        }
        for (Integer key : hashMap.keySet()) {
            Integer targetNum = hashMap.get(key);
            Integer halfLength = (nums.length + 1) / 2;
            if (targetNum >= halfLength) {
                return key;
            }
        }
        return -1;
    }

    //答案优化(直接调用api
    public static int mostNumTwo(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //随机原则得到多数
    public static int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;
        for (; ; ) {
            int candidate = nums[ranRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }

    public static int ranRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    public static int countOccurences(int nums[], int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    //找二维数组最大值优解
    public static boolean findTarget(int[][] matrix, int target) {

        int row = 0;
        int column = matrix[0].length - 1;
        int length = matrix.length;
        while (row < length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }

        }
        return false;
    }

    //合并两个有序数组

    public static int[] mergeArray(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
                index--;
            } else {
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }
        if (i < 0) {
            while (j >= 0) {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }

        return nums1;

    }


}
