package tree.binary;

public class PathSum {

  public static void main(String[] args) {
    /*TreeNode root = new TreeNode(5);
    // left Sub Tree
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(11);
    root.left.left.right = new TreeNode(2);
    root.left.left.left = new TreeNode(7);
    // Right Sub Tree
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);

    BinaryTree binaryTree = new BinaryTree(root);*/

    Node root = new Node(-2);
    root.right = new Node(-3);
    BinaryTree binaryTree = new BinaryTree(root);
    int sum = -5;
    boolean isPathSum = binaryTree.pathSum(sum);
    System.out.println(isPathSum);
  }

  private static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
      left = null;
      right = null;
    }
  }

  private static class BinaryTree{

    private Node root;

    public BinaryTree(Node root) {
      this.root = root;
    }

    public boolean pathSum(int sum) {
      return calc(root,sum,0);
    }

    private boolean calc(Node root, int sum, int sumTillNow) {
      if (root != null && sumTillNow < sum) {
        if (root.left == null && root.right == null) {
          sumTillNow += root.val;
          if (sumTillNow == sum) {
            return true;
          } else {
            return false;
          }
        }
        return calc(root.left, sum, sumTillNow + root.val) || calc(root.right, sum,
            sumTillNow + root.val);
      }else {
        return false;
      }
    }
  }
}
