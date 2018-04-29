package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/
public class ReverseLinkedList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    /*head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);*/
    LinkedList linkedList = new LinkedList(head);
    ListNode current = linkedList.head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
    linkedList.reverse();
    //Reverse
    /*System.out.println("Iterative Reversal");
    ListNode currentHead = linkedList.head;
    while (currentHead != null) {
      System.out.println(currentHead.val);
      currentHead = currentHead.next;
    }*/
    System.out.println("Recursive Reversal");
    ListNode currentHead = linkedList.head;
    while (currentHead != null) {
      System.out.println(currentHead.val);
      currentHead = currentHead.next;
    }
  }


  private static class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }


  private static class LinkedList {

    private ListNode head;

    public LinkedList(ListNode head) {
      this.head = head;
    }

    public void reverse() {
      ListNode currentNode = head;
      ListNode newNext = null;
      while (currentNode.next != null) {
        ListNode tempNext = currentNode.next;
        currentNode.next = newNext;
        newNext = currentNode;
        currentNode = tempNext;
      }
      currentNode.next = newNext;
      head = currentNode;
    }

    public void tailRecursiveReverse() {
      recursiveReverseHelper(head, null);
    }

    private void recursiveReverseHelper(ListNode currentNode, ListNode prevNode) {
      if (currentNode != null) {
        ListNode tempNode = currentNode.next;
        currentNode.next = prevNode;
        recursiveReverseHelper(tempNode,currentNode);
      }
    }

    public void normalRecursive(){

    }
  }

}
