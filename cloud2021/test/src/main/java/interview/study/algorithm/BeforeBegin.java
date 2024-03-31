package interview.study.algorithm;

import java.util.*;

public class BeforeBegin {

    public static void main(String[] args) {
//        int result = solutionTwo(new int[]{1,1,2,2,3});
//        int mostNum = majorityElement(new int[]{2,2,1,1,1,2,2});
//        boolean bool = findTarget(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},19);
//        System.out.println(bool);
        int[] nums = mergeArray(new int[]{1, 2, 3, 0, 0}, 5, new int[]{4, 5}, 2);
        for (int i : nums) {
            System.out.println(i);
        }
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

    // 整数反转
    public int reverseInteger(int a){

        // 对10整除，得到非0的部分
        // 对非0的部分反转，直接变成字符串，字符串来反转算了
        String str = "";
        // 把字符串变成char的数组，反转数组会不，不会，尴尬！

        // 大概的思路应该用指针的形势，头指针和尾指针，相互换，相互跑，啥时候试试吧，今天休息！

        //
        return 1;
    }


}
