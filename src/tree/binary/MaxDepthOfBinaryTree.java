package tree.binary;

public class MaxDepthOfBinaryTree {
  public static void main(String[] args) {

  }

  /*public int maxDepth(TreeNode root) {
    if(root == null){
      return 0;
    }
    return Math.max(1+maxDepth(root.left),1+maxDepth(root.right));
  }*/

  /*public int maxDepth(TreeNode root) {
      return scan(root, 0);
    }
    public int scan(TreeNode root, int depth){
      if (root == null) {
        return depth;
      }
      return Math.max(scan(root.left, depth + 1), scan(root.right, depth + 1));
    }*/
}
