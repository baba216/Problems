package tree.binary;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
public class SortedArrayToBalancedBST {

  public static void main(String[] args) {
    int[] input = {-10, -3, 0, 5, 9};
    BinaryTree binaryTree = new BinaryTree();
    binaryTree.convertToBST(input);
    binaryTree.inorder();

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

    public TreeNode convertToBST(int[] nums) {
      return convertToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode convertToBSTHelper(int[] nums, int start, int end) {
      if (start > end) {
        return null;
      }
      int mid = (start + end) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      if (this.root == null) {
        this.root = root;
      }
      root.left = convertToBSTHelper(nums, start, mid - 1);
      root.right = convertToBSTHelper(nums, mid + 1, end);
      return root;
    }

    public void inorder() {
      inorderHelper(root);
    }

    private void inorderHelper(TreeNode root) {
      if (root != null) {
        inorderHelper(root.left);
        System.out.println(root.val);
        inorderHelper(root.right);
      }
    }
  }
}
