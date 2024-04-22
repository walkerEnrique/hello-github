package interview.study.algorithm.DesignQuestions;

import java.util.Stack;

public class MinStack {

    // 好了好了，又没有思路了，等下还不是背答案，哎，不过又学到了Deque（Double ended queue），虽然还是不知道啥意思
    // 不过管它的，先写到这儿再说
    // 思路是什么呢，下边的瞎BB的说直接使用辅助栈；
    Stack<StackNode> stack = new Stack<>();

    // 获取栈中的最小元素
    public MinStack(){}

    // 将元素推入栈中（压栈
    public void push(int val){
        if(empty())
            stack.add(new StackNode(val,val));
        else {
            stack.add(new StackNode(val,Math.min(val,getMin())));
        }
    }

    // 获取栈中的第一个元素
    public void pop(){
        if(empty())
            throw new IllegalStateException("栈为空。。。");
        stack.pop();
    }

    // 获取栈中最大元素的值
    public int getMax(){
        if(empty())
            throw new IllegalStateException("栈为空。。。");
        return stack.peek().val;
    }

    // 获取栈中的最小元素
    public int getMin(){
        if(empty())
            throw new IllegalStateException("栈为空。。。。");
        return stack.peek().min;
    }

    // 判断是否为空
    public boolean empty(){
        return stack.isEmpty();
    }

    /**
     * Your MinStack will be instantiated and called as such:
     * MinStack minStack = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = minStack.top();
     * int param_4 = minStack.getMin();
     */
}

class StackNode{

    public int val;
    public int min;

    public StackNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}
