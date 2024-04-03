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
        System.out.println(myAsciiToInteger("2147483648"));

    }

    // 验证AsciiToInt算法，说了老实话，有点搞不明白啊，这里边肯定用了Ascii码和字符或者数字的对应关系，回去啥时候看看吧。。
    public static int myAsciiToInteger(String s) {

        // 丢弃前边无用的前导空格
        s = s.trim();
        // 如果长度为零，返回0
        if (s.length() == 0) {
            return 0;
        }
        // 遍历字符中的数字
        int index = 0;
        // 最后输出的结果
        int result = 0;
        // 判断符号，1是正数，-1为负数，默认为整数
        int flag = 1;
        // 定义字符串长度，为嘛要用这个呢
        int length = s.length();
        if (s.charAt(index) == '-' || s.charAt(index) == '+') {
            flag = s.charAt(index++) == '+' ? 1 : -1;
        }
        // 取出来字符串的字符，然后转换成数字
        for (; index < length; ++index) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // 越界处理，这里是日了狗的边界处理，这些个为嘛要这样判断啊。。最后一次的上一次判断，得到的这些东西？应该是吧，再说咯
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                result = result * 10 + digit;
            }
        }
        return result * flag;
    }

    // 外观数列
    public static int countAndSay(int a) {

        // 数列是对前一项的描述；for example；
        // 1，的后一项“一个1”
        // 11，的后一项“两个个1”
        // 21，的后一项“一个2，一个1”
        // 1211，的后一项“一个1，一个2，二个1”
        // 111221，的后一项“三个1，两个2，一个1”
        // 312211;

        // 规律找到了，现在是输入一个整数，输出他对应的字符串值，比如输入整数4，输出“1211”
        // 网上说的是递归+双指针的做法，我也是这样想的，其实我啥也没想，但思路至少有了。

        // 飞机打多了，有点烦躁，IELTS还要复习，还要看面试的东西，还要学习下区块链，还要刷算法题
        // 一时间有点无从下手，本来是上午看面试题，下午刷算法的，结果现在连晚上都要看雅思了吗，
        // 问题是雅思也有一点看不懂噢，现在听英语有点像听天书样，还是飞机打多了，怪不得黄赌毒里边黄是第一个呢
        // 那些吸毒的估计也差不多吧，是不是阴阳调和一下就会好很多呀，毕竟两个一起做运动，发汗了，明天出去理发
        // 然后锻炼下，发下汗，排下身体里的杂质，今天先这样吧，把代码提交了，明天又是充满希望的一日！！！



        return 1;
    }

    // 整数反转
    public static int reverseInteger(int a) {

        int res = 0;
        while (a != 0) {
            // 设定了一个值，初始化为0，对10做乘法，再对传入10取余，得到最后一位
            res = res * 10 + a % 10;
            // 为嘛要判断这俩相同不呢
            if (res % 10 != a % 10) {
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
