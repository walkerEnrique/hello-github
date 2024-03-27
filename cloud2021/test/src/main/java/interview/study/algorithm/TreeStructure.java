package interview.study.algorithm;

/*
    这是一个树结构
 */
public class TreeStructure {

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

    public int maxDepth(TreeNode root){

        return 1;
    }

}
