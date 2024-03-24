package interview.study.algorithm;

import java.util.*;

public class SumTwo {

    public static void main(String[] args) {
//        Integer[] array1 = new Integer[]{2, 7, 11, 15};
//        int[] array2 = {2, 7, 11, 15};
//        int target = 9;
//        for (int element : sumTwoOne(array1, target)) {
//            System.out.println(element);
//        }
//        System.out.println(sumTwoTwo(array,target));

        //测试链表创建
        ListNode node1 = new ListNode(1, "1");
        ListNode node2 = new ListNode(2, "1");
        ListNode node3 = new ListNode(3, "1");
        ListNode node4 = new ListNode(4, "1");

        ListNode node = new ListNode();
        node.add(node1);
        node.add(node2);
        node.add(node3);
        node.add(node4);

//        System.out.println(node.isPalindrome(node));
        System.out.println(node.isPalindromeReferenceAnswer(node1));



    }

    //在一个数组当中,找到目标值
    public static int[] sumTwoOne(Integer[] array, int target) {
        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(array));
        for (int i = 0; i < arrayList.size(); i++) {
            int subtraction = target - arrayList.get(i);
            if (arrayList.contains(subtraction)) {
                return new int[]{arrayList.indexOf(subtraction), i};
            }
        }
        return null;
    }

    // 第二种解法
    public static int[] sumTwoTwo(int[] array, int target) {
        Map<Object, Integer> map = new HashMap<Object, Integer>();
        for (int i = 0; i < array.length; i++) {
            int subtraction = target - array[i];
            if (map.containsKey(subtraction)) {
                return new int[]{map.get(subtraction), i};
            }
            map.put(array[i], i);
        }
        return null;
    }

    /*
    回文链表
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
        int val;
        Object obj;
        ListNode next;

        ListNode() {
        }


        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Object object) {
            this.val = val;
            this.obj = object;
        }

        ListNode(int val, Object object, ListNode next) {
            this.val = val;
            this.obj = object;
            this.next = next;
        }

        public void add(ListNode linkedNode) {
            //此时需要一个辅助节点
            ListNode temp = new ListNode(0,"0");

            //遍历找到最后一个节点
            while (true) {
                if (temp.next == null) {
                    break;
                }
                //没有找到最后一个节点，辅助节点 temp 就向后移动们继续遍历
                temp = temp.next;
            }
        }

    /*
    回文鏈表具体实现
     */

        public boolean isPalindrome(ListNode head) {

            // 定义两个快慢指针节点
            ListNode slow = head, fast = head;

            // 便利链表，跑的快的比跑的慢的多一倍的路程，当快指针到末尾时，慢指针才到一般左右；
            while (fast.next != null && slow.next != null) {
                fast = head.next.next;
                slow = head.next;
            }

            // 如果fast不为空，证明是链表长度是奇数个
            if (fast != null) {
                slow = slow.next;
            }
            // 反转后半部分链表
            slow = reverseLinklist(slow);

            fast = head;

            // 遍历前后部分链表，对比是否是回文列表
            // 他吗的这儿报错了，还不知道为什么，日了dog，我还辛苦的背了半天都不知道对不对！回去再测试下，（不测了，打游戏去了难受。。睡觉了
            // 等下再测下反转链表对不对。。
            while (slow != null) {
                if (fast.val != slow.val)
                    return false;
                fast = fast.next;
                slow = slow.next;
            }

            return true;
        }

        private ListNode reverseLinklist(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            return prev;
        }

        public boolean isPalindromeReferenceAnswer(ListNode head) {

            List<Integer> vals = new ArrayList<Integer>();

            // 将链表的值复制到数组中
            ListNode currentNode = head;
            while (currentNode != null) {
                vals.add(currentNode.val);
                currentNode = currentNode.next;
            }

            // 使用双指针判断是否回文
            int front = 0;
            int back = vals.size() - 1;
            while (front < back) {
                if (!vals.get(front).equals(vals.get(back))) {
                    return false;
                }
                front++;
                back--;
            }
            return true;
        }
    }
}
