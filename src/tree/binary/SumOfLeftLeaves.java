package tree.binary;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/sum-of-left-leaves/description/
public class SumOfLeftLeaves {

  public static void main(String[] args) {
    Node root = new Node(3);
    root.left = new Node(5);
    root.left.left  = new Node(10);
    root.right = new Node(20);
    root.right.right = new Node(7);
    root.right.right.left = new Node(5);
    root.right.left = new Node(15);
    BinaryTree binaryTree = new BinaryTree(root);
    int sum = binaryTree.leftLeavesSum();
    System.out.println(sum);
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


  private static class BinaryTree {

    private Node root;

    public BinaryTree(Node root) {
      this.root = root;
    }

    public int leftLeavesSum(){
      return process(root);
    }

    private int process(Node root) {
      int sum = 0;
      Queue<Node> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);
      while (!nodeQueue.isEmpty()){
        Node currentNode = nodeQueue.poll();
        if(currentNode.left != null) {
          Node leftChildNode = currentNode.left;
          if (leftChildNode.left == null && leftChildNode.right == null) {
            sum += leftChildNode.val;
          }else {
            nodeQueue.add(leftChildNode);
          }
        }
        if(currentNode.right != null){
          Node rightChildNode = currentNode.right;
          if(rightChildNode.left != null || rightChildNode.right != null){
            nodeQueue.add(rightChildNode);
          }
        }
      }
      return sum;
    }

  }
}
