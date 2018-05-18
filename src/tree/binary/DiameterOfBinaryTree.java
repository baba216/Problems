package tree.binary;

//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterOfBinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    /*root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.right = new TreeNode(9);
    root.right.right.right.right = new TreeNode(10);*/
    BinaryTree binaryTree = new BinaryTree(root);
    //int diameter = binaryTree.diameter();
    int result = binaryTree.diameterBestApproach();
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

    private final TreeNode root;

    private int result = 0;

    public BinaryTree(TreeNode root) {
      this.root = root;
    }

    private int diameter() {
      if (root == null) {
        return 0;
      }
      return diameterHelper(root);
    }

    private int diameterHelper(TreeNode root) {
      if (root == null) {
        return 0;
      }
      return Math.max(depth(root.left) + depth(root.right),
          Math.max(diameterHelper(root.left), diameterHelper(root.right)));
    }

    private int depth(TreeNode root) {
      if (root == null) {
        return 0;
      } else {
        return Math.max(depth(root.left), depth(root.right)) + 1;
      }
    }

    public int diameterBestApproach() {
      if (root == null) {
        return 0;
      }
      bestApproachHelper(root);
      return result;
    }

    private int bestApproachHelper(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int leftHeight = bestApproachHelper(root.left);
      int rightHeight = bestApproachHelper(root.right);
      result = Math.max(result, (leftHeight + rightHeight));
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
