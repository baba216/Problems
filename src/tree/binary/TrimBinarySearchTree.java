package tree.binary;

//https://leetcode.com/problems/trim-a-binary-search-tree/description/
public class TrimBinarySearchTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(1);
    root.right = new TreeNode(4);
    BinaryTree binaryTree = new BinaryTree(root);
    int L = 1;
    int R = 3;
    binaryTree.inOrderTraversal();
    binaryTree.trim(L, R);
    binaryTree.inOrderTraversal();

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

    public TreeNode trim(int L, int R) {
      if (root == null) {
        return null;
      }
      return trimHelper(root, L, R);
    }

    private TreeNode trimHelper(TreeNode root, int L, int R) {
      if (root == null) {
        return null;
      }
      if (root.val < L) {
        root.left = null;
        return trimHelper(root.right, L, R);
      }
      if (root.val > R) {
        root.right = null;
        return trimHelper(root.left, L, R);
      }
      root.left = trimHelper(root.left, L, R);
      root.right = trimHelper(root.right, L, R);
      return root;
    }

    public void inOrderTraversal() {
      System.out.println("InOrder:");
      inOrderTraversalHelper(root);
    }

    private void inOrderTraversalHelper(TreeNode root) {
      if (root != null) {
        inOrderTraversalHelper(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalHelper(root.right);
      }
    }
  }
}
