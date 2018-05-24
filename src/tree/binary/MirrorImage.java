package tree.binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
//https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/mirror-image-2/
public class MirrorImage {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    nodeMap.put(1, new TreeNode(1));
    int N = Integer.parseInt(tokenizer.nextToken());
    int Q = Integer.parseInt(tokenizer.nextToken());
    while (--N > 0) {
      tokenizer = new StringTokenizer(reader.readLine());
      int parent = Integer.parseInt(tokenizer.nextToken());
      int child = Integer.parseInt(tokenizer.nextToken());
      String dir = tokenizer.nextToken();
      TreeNode node = nodeMap.get(parent);
      if ("L".equals(dir)) {
        node.left = new TreeNode(child);
        nodeMap.put(child, node.left);
      } else {
        node.right = new TreeNode(child);
        nodeMap.put(child, node.right);
      }
    }
    TreeNode root = nodeMap.get(1);
    BinaryTree binaryTree = new BinaryTree(root);
    binaryTree.inOrderTraversal();
    while (Q-- > 0) {
      int nodeValue = Integer.parseInt(reader.readLine());
      int result = binaryTree.mirrorImage(nodeValue);
      writer.write(result+"");
      writer.newLine();
    }
    writer.flush();
    writer.close();
  }

  private static class TreeNode {

    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
      this.val = val;
    }
  }


  private static class BinaryTree {

    private final TreeNode root;


    private BinaryTree(TreeNode root) {
      this.root = root;
    }

    public int mirrorImage(int nodeValue) {
      if (nodeValue == root.val) {
        return nodeValue;
      }
      Queue<TreeNode> leftSubtree = new LinkedList<>();
      Queue<TreeNode> rightSubtree = new LinkedList<>();
      leftSubtree.offer(root);
      rightSubtree.offer(root);
      while (!leftSubtree.isEmpty() && !rightSubtree.isEmpty()) {
        TreeNode leftSubtreeChild = leftSubtree.poll();
        TreeNode rightSubtreeChild = rightSubtree.poll();
        if (leftSubtreeChild.left != null && leftSubtreeChild.left.val == nodeValue) {
          return rightSubtreeChild.right != null ? rightSubtreeChild.right.val : -1;
        }
        if (leftSubtreeChild.right != null && leftSubtreeChild.right.val == nodeValue) {
          return rightSubtreeChild.left != null ? rightSubtreeChild.left.val : -1;
        }
        if (rightSubtreeChild.right != null && rightSubtreeChild.right.val == nodeValue) {
          return leftSubtreeChild.left != null ? leftSubtreeChild.left.val : -1;
        }
        if (rightSubtreeChild.left != null && rightSubtreeChild.left.val == nodeValue) {
          return leftSubtreeChild.right != null ? leftSubtreeChild.right.val : -1;
        }
        if (leftSubtreeChild.left != null && rightSubtreeChild.right != null) {
          leftSubtree.offer(leftSubtreeChild.left);
          rightSubtree.offer(rightSubtreeChild.right);
        }
        if (leftSubtreeChild.right != null && rightSubtreeChild.left != null) {
          leftSubtree.offer(leftSubtreeChild.right);
          rightSubtree.offer(rightSubtreeChild.left);
        }
      }
      return -1;
    }

    public void inOrderTraversal() {
      inOrderTraversalHelper(root);
    }

    private void inOrderTraversalHelper(TreeNode root) {
      if (root != null) {
        inOrderTraversalHelper(root.left);
        System.out.println(root.val);
        inOrderTraversalHelper(root.right);
      }
    }
  }
}
