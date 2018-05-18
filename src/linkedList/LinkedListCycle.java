package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/773/
public class LinkedListCycle {

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(3);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = head.next;
    LinkedList linkedList = new LinkedList(head);
    boolean result = linkedList.hasCycle();
    System.out.println(result);
  }

  private static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }


  private static class LinkedList {

    private final ListNode head;


    private LinkedList(ListNode head) {
      this.head = head;
    }

    public boolean hasCycle() {
      return hasCycleHelper(head);
    }

    private boolean hasCycleHelper(ListNode head) {
      ListNode doublePointer = head.next;
      while (head != null && doublePointer != null) {
        if (head == doublePointer) {
          return true;
        }
        head = head.next;
        if (doublePointer.next == null) {
          return false;
        }
        doublePointer = doublePointer.next.next;
      }
      return false;
    }
  }
}
