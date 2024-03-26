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
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        node = new ListNode().reverseLinklist(node);

//        System.out.println(node.isPalindromeReferenceAnswer(node));

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }

    //在一个数组当中,找到目标值，kawasakiTrump
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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val, Object object, ListNode next) {
            this.val = val;
            this.obj = object;
            this.next = next;
        }

        public void add(ListNode linkedNode) {
            //此时需要一个辅助节点
            ListNode temp = new ListNode(0);

            //遍历找到最后一个节点
            while (temp != null) {
                //没有找到最后一个节点，辅助节点 temp 就向后移动们继续遍历
                temp = temp.next;
            }
        }

        private ListNode reverseLinklist(ListNode head) {
            // 定义null，为空的时候就到链表结尾了
            ListNode prev = null;
            while (head != null) {
                // 存储头节点的下一个节点
                // 留着下一步访问
                ListNode next = head.next;
                // 相当于把新链表放在原来旧链表的每一个位置
                // 头节点的下一个结点指向null
                head.next = prev;
                // 头节点给先前的节点
                prev = head;
                // 头节点的下一个节点给头，相当于逆序遍历
                head = next;
            }
            // 返回变更后的头节点
            return prev;
        }

        // 回文链表标准答案
        public boolean isPalindromeReferenceAnswer(ListNode head) {

            List<Integer> vals = new ArrayList<Integer>();

            // 将链表的值复制到数组中
            ListNode currentNode = head;
            while (currentNode != null) {
                vals.add(currentNode.val);
                // 这才叫遍历，下一个节点变成当前节点，节点继续循环往下走。
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

        // 环形链表，
        public boolean hasCycle(ListNode head){
            // 分两种情况，一种是半截分叉环过来了，还有一种是末尾分叉环到前边去了。。
            // 循环遍历下，如果有重复的直接break；看能搞定不，不想写算法题了，还是吹牛比好玩。。
            // 定义一个集合装数据
            List list = new ArrayList<Integer>();
            while(head != null ){
                if(list.contains(head.val)){
                    return true;
                }
                list.add(head.val);
                head = head.next;
            }
            return false;
        }
    }
}
