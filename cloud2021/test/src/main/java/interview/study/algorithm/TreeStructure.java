package interview.study.algorithm;

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
                            new TreeNode(4),new TreeNode(4)),new TreeNode(3)),
                // 这个可以尝试到第五层；
                // 右边的
                new TreeNode(2,
                        // 第三层子节点
                        new TreeNode(3,
                                // 第四层在左边，第五曾尝试从右边走
                                new TreeNode(4),new TreeNode(4,
                                // 勒，从右边走的第五层，我特么的看了半天，这破玩意，也不知道哪错了，还是删了重来爽。。
                                new TreeNode(5),new TreeNode(5))),new TreeNode(3)));

        TreeStructure treeStructure = new TreeStructure();

        System.out.println(treeStructure.maxDepth(node));


    }

    /*
        这才是一个树结构
     */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    /*
        计算树结构的最大深度
        递归（拿个乌龟在那递，笑死）
     */
    public int maxDepth(TreeNode root){
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    // 打印树结构，什么BFM（队列先进先出）,DFS（栈空间压栈，先进后出来），反正就是遍历，放进去再出来，
    // 具体什么的明天再说吧，今天下班了，今天的电诈还没开始呢
    // 验证二叉搜索树；这个明天用一下咯



}
