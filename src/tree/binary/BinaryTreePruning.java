package tree.binary;

//https://leetcode.com/contest/weekly-contest-79/problems/binary-tree-pruning/
public class BinaryTreePruning {

  public static void main(String[] args) {
    /*TreeNode root = new TreeNode(1);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(1);*/


    TreeNode root = new TreeNode(0);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(0);

    BinaryTree binaryTree = new BinaryTree(root);
    binaryTree.prune();
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


    public TreeNode prune() {
      return pruneHelper(root);
    }

    private TreeNode pruneHelper(TreeNode root) {
      if (root != null) {
        root.left = pruneHelper(root.left);
        root.right = pruneHelper(root.right);
        if (root.val == 0) {
          if (root.left == null && root.right == null) {
            return null;
          }else {
            return root;
          }
        }else {
          return root;
        }
      }
      return null;
    }

    public void inOrderTraversal() {
      inOrder(root);
    }

    private void inOrder(TreeNode root) {
      if (root != null) {
        inOrder(root.left);
        inOrder(root.right);
        System.out.println(root.val);
      }
    }
  }
}
