package tree.binary;
// WA
public class BinaryTreeTilt {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(10);

    BinaryTree binaryTree = new BinaryTree(root);
    int result = binaryTree.tilt();
    System.out.println(result);
  }


  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
      this.val = val;
      left = null;
      right = null;
    }
  }


  private static class BinaryTree {

    TreeNode root;

    public BinaryTree(TreeNode root) {
      this.root = root;
    }

    public int tilt() {
      if(root == null){
        return 0;
      }
      return calculateTilt(root) - root.val;
    }

    private int calculateTilt(TreeNode root) {
      if (root != null) {
        int leftSubtreeTilt = calculateTilt(root.left);
        int rightSubTreeTilt = calculateTilt(root.right);
        return Math.abs(leftSubtreeTilt - rightSubTreeTilt) + root.val;
      } else {
        return 0;
      }
    }
  }

}
