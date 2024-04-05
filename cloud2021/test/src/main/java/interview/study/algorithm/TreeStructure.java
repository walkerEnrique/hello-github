package interview.study.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    这是一个树结构
 */
public class TreeStructure {

    public static void main(String... args) {
        // 构造一个树结构；
        TreeNode node = new TreeNode(1,
                // 左边的，现在在第二层
                new TreeNode(2,
                        // 第三层子节点
                        new TreeNode(3,
                                // 第四层子节点，还是从左边走的
                                new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                // 这个可以尝试到第五层；
                // 右边的
                new TreeNode(2,
                        // 第三层子节点
                        new TreeNode(3,
                                // 第四层在左边，第五曾尝试从右边走
                                new TreeNode(4), new TreeNode(4,
                                // 勒，从右边走的第五层，我特么的看了半天，这破玩意，也不知道哪错了，还是删了重来爽。。
                                new TreeNode(5), new TreeNode(5))), new TreeNode(3)));

        TreeStructure treeStructure = new TreeStructure();
        System.out.println(treeStructure.maxDepth(node));
    }

    /*
        这才是一个树结构
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    /*
        计算树结构的最大深度
        递归（拿个乌龟在那递，笑死）
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // 打印树结构，什么BFM（队列先进先出）,DFS（栈空间压栈，先进后出来），反正就是遍历，放进去再出来，
    // 具体什么的明天再说吧，今天下班了，今天的电诈还没开始呢
    // 验证二叉搜索树；用了啥中历遍归噢，搞不懂，日常水一下
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;
        //每个节点如果超过这个范围，直接返回false
        if (root.val >= maxVal || root.val <= minVal)
            return false;
        //这里再分别以左右两个子节点分别判断，
        //左子树范围的最小值是minVal，最大值是当前节点的值，也就是root的值，因为左子树的值要比当前节点小
        //右子数范围的最大值是maxVal，最小值是当前节点的值，也就是root的值，因为右子树的值要比当前节点大
        // 左边的最小值是节点的值，当前节点值是最大的；
        // is ValidBTS(root.left,minVal,root,val);
        // 右边值是最小的，当前节点值是最小的
        // is ValidBTS（root.right,root.val,maxVal）;
        // 俩同时成立才行,力扣那沙雕网站，用int还不行，还得用long，真是服了
        // 初始化小的在前边，节约一点内存空间。

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    // 对称二叉树

    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.val >= 100 || node.val <= -100) {
            return false;
        }
        return isSymmetricHelper(node.left, node.right);
    }

    // 用递归的方法做
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 当前节点只有一个或者两个的左右节点都不相同，直接返回false；
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 比较每一层的数
        // 对称二叉树，就像镜子一样一样的，可以折叠过来覆盖；左树的左边对应右树的右边，左数的右边对应右数的左边；
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    // 用迭代的方法做，算了，不做了，有点麻烦。。

    // 二叉树的层序遍历
    // BFS(breadth first search) 广度优先搜索，这个题先用这个试试
    // DFS(depth first search)；深度优先算法，这个暂时放在这儿，等我看完篇文章，然后再把这个算法题做了。
    public List<List<Integer>> levelOrder(TreeNode node) {

        if (node == null) {
            return new ArrayList<List<Integer>>();
        }
        // 定义需要的集合
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        // 定义需要的队列，队列就相当于一个链表？
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.add(node);
        // 如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            // BFS打印，每层的节点数为levelNumber
            int levelNumber = queue.size();
            // subList存每层的节点值
            List<Integer> subList = new ArrayList<Integer>();
            // 循环打印每层的数据，并存入队列中
            for (int i = 0; i < levelNumber; i++) {
                // 出队
                TreeNode root = queue.poll();
                subList.add(root.val);
                // 左右节点不为空则加入队列中
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            // 每层都存到list中
            list.add(subList);
        }
        return list;
    }

    //将有序数组转化为平衡二叉树
    public TreeNode sortedTreeToBST(int[] nums){

        // 什么是平衡二叉树，平衡二叉树就是左右两边一样的，要不递增，要不就一起递减
        // 首先咱们学会怎么样遍历树结构，使用层序遍历，还是其他遍历，我好像只做过层序遍历
        // 详情看一看上一个方法，怎么做还不晓得，先把牛比给吹到这儿。

        return null;
    }

}
