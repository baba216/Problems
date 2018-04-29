package tree.binary;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
public class TwoSumIV {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(7);
    BinaryTree binaryTree = new BinaryTree(root);
    int k = 3;
    boolean result = binaryTree.pathSum(k);
    boolean result1 = binaryTree.isPathSum(k);
    System.out.println(result1);
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

    /**
     * My Approach
     */
    public boolean pathSum(int k) {
      return getArrayListFromTree(root, new HashSet<>(), k);
    }

    private boolean getArrayListFromTree(TreeNode root, Set<Integer> complimentLocation,
        Integer k) {
      if (root != null) {
        boolean isSumPresentInLeftSubTree = getArrayListFromTree(root.left, complimentLocation, k);
        if (!isSumPresentInLeftSubTree) {
          int compliment = k - root.val;
          if (complimentLocation.contains(compliment)) {
            return true;
          }
          complimentLocation.add(root.val);
          return getArrayListFromTree(root.right, complimentLocation, k);
        } else {
          return true;
        }
      }
      return false;
    }

    /**
     * Best Solution Approach
     */
    public boolean isPathSum(int k) {
      return traverseTreeAndGetPathSum(root, root, k);
    }

    private boolean traverseTreeAndGetPathSum(TreeNode root, TreeNode currentNode, int k) {
      if (currentNode == null) {
        return false;
      } else {
        return traverseTreeAndGetPathSum(root, currentNode.left, k) || traverseTreeAndGetPathSum(
            root, currentNode.right, k) || findValueBST(root, k - currentNode.val, currentNode);
      }
    }

    private boolean findValueBST(TreeNode root, int compliment, TreeNode skipNode) {
      if (root != null) {
        if (root.val == compliment && root != skipNode) {
          return true;
        } else if (root.val > compliment) {
          return findValueBST(root.left, compliment, skipNode);
        } else {
          return findValueBST(root.right, compliment, skipNode);
        }
      }
      return false;
    }
  }
}
