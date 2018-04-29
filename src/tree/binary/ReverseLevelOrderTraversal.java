package tree.binary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
public class ReverseLevelOrderTraversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    BinaryTree binaryTree = new BinaryTree(root);
    System.out.println("Height:"+binaryTree.findHeight());
    List<List<Integer>> result = binaryTree.reverseLevelOrderSecondApproach();
    //result.forEach(System.out::println);
    List<List<Integer>> result1 = binaryTree.reverseLevelOrderFirstApproach();
    result1.forEach(System.out::println);
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

    public List<List<Integer>> reverseLevelOrderFirstApproach(){
      if(root == null){
        return new ArrayList<>();
      }
      List<List<Integer>> result = new LinkedList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        List<Integer> particularLevelData = new LinkedList<>();
        Queue<TreeNode> nextLevelNodes = new LinkedList<>();
        while (!queue.isEmpty()) {
          TreeNode currentNode = queue.poll();
          particularLevelData.add(currentNode.val);
          if (currentNode.left != null) {
            nextLevelNodes.add(currentNode.left);
          }
          if (currentNode.right != null) {
            nextLevelNodes.add(currentNode.right);
          }
        }
        queue = nextLevelNodes;
        result.add(particularLevelData);
      }
      Collections.reverse(result);
      return result;
    }

    public List<List<Integer>> reverseLevelOrderSecondApproach() {
      int height = findHeight();
      List<List<Integer>> result = new LinkedList<>();
      for (int i = 1; i <= height; i++) {
        List<Integer> dataAtCurrentLevel = new LinkedList<>();
        appendElementsAtLevel(root, i, dataAtCurrentLevel);
        result.add(dataAtCurrentLevel);
      }
      return result;
    }

    private void appendElementsAtLevel(TreeNode root, int height,
        List<Integer> dataAtCurrentLevel) {
      if (root == null) {
        return;
      } else if (height == 1) {
        dataAtCurrentLevel.add(root.val);
      } else if (height > 1) {
        appendElementsAtLevel(root.left, height - 1, dataAtCurrentLevel);
        appendElementsAtLevel(root.right, height - 1, dataAtCurrentLevel);
      }
    }

    public int findHeight() {
      return calculateHeight(root);
    }

    private int calculateHeight(TreeNode root) {
      if (root == null) {
        return 0;
      } else {
        int leftSubTreeHeight = 1 + calculateHeight(root.left);
        int rightSubTreeHeight = 1 + calculateHeight(root.right);
        return Math.max(leftSubTreeHeight, rightSubTreeHeight);
      }
    }
  }
}
