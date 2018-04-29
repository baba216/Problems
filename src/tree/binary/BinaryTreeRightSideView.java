//https://leetcode.com/problems/binary-tree-right-side-view/description/
package tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    BinaryTree binaryTree = new BinaryTree(root);
    binaryTree.printRightSideView(root,root.left);
    List<Integer> result = binaryTree.rightSideView();
    System.out.println(result);

  }

  public static class BinaryTree {

    private Node root;

    public BinaryTree(Node root) {
      this.root = root;
    }

    public void rightSideView_2(Node root, List<Integer> result, int depth){
        if(root == null){
          return;
        }else {
          if (result.size() == depth) {
              result.add(root.data);
          }
          rightSideView_2(root.right,result,depth+1);
          rightSideView_2(root.left,result,depth+1);
        }
      }

    //reverse level order traversal
    public  List<Integer> rightSideView(){
      List<Integer> result = new ArrayList<>();
      if(root == null){
        return result;
      }
      Queue<Node> nodeQueue = new LinkedList<>();
      nodeQueue.offer(root);
      while (nodeQueue.size() != 0){
        int size = nodeQueue.size();
        for (int i = 0; i < size ; i++) {
            Node current = nodeQueue.poll();
            if(i==0){
              result.add(current.data);
            }
            if(current.right != null){
              nodeQueue.offer(current.right);
            }
            if(current.left != null){
              nodeQueue.offer(current.left);
            }
        }
      }
      return result;
    }

    // my solution WA
    void printRightSideView(Node root, Node leftTreePointer) {
      if (root == null) {
        return;
      }
      System.out.println(root.data);
      if (root.right == null && root.left == null) {
        printRightSideView(leftTreePointer, null);
      }
      if (root.right != null) {
        if(leftTreePointer != null) {
          if (leftTreePointer.right != null) {
            leftTreePointer = leftTreePointer.right;
          } else {
            leftTreePointer = leftTreePointer.left;
          }
        }
        printRightSideView(root.right, leftTreePointer);
      }else {
        // left node is not null
        if(leftTreePointer != null) {
          if (leftTreePointer.right != null) {
            leftTreePointer = leftTreePointer.right;
          } else {
            leftTreePointer = leftTreePointer.left;
          }
        }
        printRightSideView(root.left, leftTreePointer);
      }
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
