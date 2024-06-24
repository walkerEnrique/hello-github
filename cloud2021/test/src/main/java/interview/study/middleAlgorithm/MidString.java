package interview.study.middleAlgorithm;

import controller.People;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MidString {

    public static void main(String[] args) {
        // 为嘛会有十个元素呢，不是五个吗，就是五个。。
        List<People> list= IntStream.range(20,25).mapToObj(i->new People("Stephen",i)).collect(Collectors.toList());
        System.out.println(list.size());

        MidString midString = new MidString();

    }

    // 给你一个字符串str，分割此字符串，使得所有的字符串返回的都是回文串，返回所有的可能；
    private List<List<String>> partition(String str){
        List<List<String>> list = null;
        return null;
    }

    // 单词拆分
    private boolean wordBreak(String str,List<String> wordDict){
        // 怎么还要用BFS呀，不过看着挺简单的，好背就行，嘻嘻，不嘻嘻
        // 定义一个队列，可以出队和进队
        Queue<Integer> queue = new LinkedList<>();
        // 定义一个set集合
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        // 当队列里边还有东西，while循环一下
        while(!queue.isEmpty()){
            // 定义第一个出的为当前坐标
            Integer index = queue.poll();
            // 循环当前坐标，开始就是index，终止是str的长度
            for(int i = index;i<=str.length();i++){
                // 如果集合set有这个数据？就直接下次循环
                if(set.contains(i))continue;
                if(wordDict.contains(str.substring(index,i))){
                    if(i==str.length())return true;
                    queue.offer(i);
                    final boolean add = set.add(i);
                }
            }
        }
        return false;
    }

    // 单词拆分2
    // 说个老实话，我有点看不懂这个题目，特别是最后一个，明明就可以拼接出来字符串啊
    // anyway，tomorrow is another wonderful day
    // a good story is always waiting for someone to tell
    // you have lived another day, you are already better than yesterday!
    private boolean wordBreak2(String str, List<String> list){

        return true;
    }

    // 单词搜索
    // 给定一个字符表格，返回二位网格上的所有单词，单词还必须按照字母顺序
    // 完蛋，一看就不会，不会就拉到
    private List<String> findWords(char[][] board,String[] words){

        return null;
    }


}
