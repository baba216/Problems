package tree.binary;

import java.util.Stack;

public class AllNodesKDistranceFromLeaf {

  public static void main(String[] args) {
      BinaryTree binaryTree = new BinaryTree(new Node(1));
      binaryTree.root.left = new Node(2);
      binaryTree.root.left.left = new Node(4);
      binaryTree.root.left.right = new Node(5);
      binaryTree.root.right = new Node(3);
      binaryTree.root.right.right = new Node(7);
      binaryTree.root.right.left = new Node(6);
      binaryTree.root.right.left.right = new Node(8);
      binaryTree.inOrder(binaryTree.root);

  }

  public static class BinaryTree {

    private final Node root;

    public BinaryTree(Node root) {
      this.root = root;
    }

    void inOrder(Node root){
      if(root != null){
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
      }
    }

    void allNodeKDistanceFromLeaf(){
      Stack<Node> nodeStack = new Stack<>();
      //traverseIn
    }

  }


  public static class Node {

    int data;
    Node right;
    Node left;

    public Node(int data) {
      this.data = data;
      this.right = null;
      this.left = null;
    }
  }
}
