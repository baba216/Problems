package tree.binary;

public class PrintNodesAtkDistanceFromRoot {

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    Node root = new Node(1);
    tree.root = root;
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.left = new Node(8);
    root.left.right = new Node(5);
    root.left.left = new Node(4);
    tree.inOrder(root);
    tree.printKDistance(root,3);
  }


  public static class BinaryTree{

    Node root;

    void inOrder(Node root){
      if(root != null){
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
      }
    }

    void printKDistance(Node root, int k) {
      if (root == null) {
        return;
      } else if (k == 0) {
        System.out.println("TreeNode:" + root.data);
      } else {
        printKDistance(root.left, k - 1);
        printKDistance(root.right, k - 1);
      }
    }
  }

  public static class Node{
    int data;
    Node left,right;

    public Node(int data) {
      this.data = data;
      left = null;
      right = null;
    }
  }
}
