package tree.binary;

import java.util.Stack;

public class BSTtoGreaterTree {

  public static void main(String[] args) {
    Node root = new Node(20);
    root.left = new Node(10);
    root.left.left = new Node(5);
    root.left.right = new Node(15);
    root.right = new Node(30);
    root.right.left = new Node(25);
    root.right.right = new Node(35);
    BinaryTree binaryTree = new BinaryTree(root);
    binaryTree.inOrder(root);
    System.out.println("======");
    binaryTree.convertToGreaterTree();
    binaryTree.inOrder(root);
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

    private final Node root;

    public BinaryTree(Node root) {
      this.root = root;
    }

    private void inOrder(Node root) {
      if (root != null) {
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
      }
    }

    private void convertToGreaterTree() {
      recursiveHelper(root, new Stack<>());
      //iterativeHelper(root);
    }

    private void iterativeHelper(Node root) {
      Stack<Node> nodeStack = new Stack<>();
      nodeStack.push(root);
      Node travelPointer = root;
      int sum = 0;
      while (!nodeStack.isEmpty()) {
        // do a check here
        while (travelPointer != null && travelPointer.right != null) {
          travelPointer = travelPointer.right;
          nodeStack.push(travelPointer);
        }
        Node processingNode = nodeStack.pop();

        sum += processingNode.val;
        processingNode.val = sum;
        travelPointer = null;
        if (processingNode.left != null) {
          travelPointer = processingNode.left;
          nodeStack.push(travelPointer);
        }
      }
    }

    private void recursiveHelper(Node root, Stack<Node> nodes) {
      if (root != null) {
        recursiveHelper(root.right, nodes);
        if (!nodes.isEmpty()) {
          Node lastNode = nodes.peek();
          root.val += lastNode.val;
        }
        nodes.push(root);
        recursiveHelper(root.left, nodes);
      }
    }
  }
}
