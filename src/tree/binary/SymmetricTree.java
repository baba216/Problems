package tree.binary;
//https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/627/
public class SymmetricTree {

  public static void main(String[] args) {
    /*TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(3);
    BinaryTree binaryTree = new BinaryTree(root);*/
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    BinaryTree binaryTree = new BinaryTree(root);
    System.out.println(binaryTree.isSymetric());
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

    private TreeNode root;

    public BinaryTree(TreeNode root) {
      this.root = root;
    }

    public boolean isSymetric() {
      return checkSymetricity(root.left, root.right);
    }

    private boolean checkSymetricity(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
        return true;
      }
      if (left == null && right != null) {
        return false;
      }
      if (right == null && left != null) {
        return false;
      }
      if (left.val != right.val) {
        return false;
      }
      return checkSymetricity(left.left, right.right) && checkSymetricity(left.right, right.left);
    }

  }

}
