package linkedList;

public class PalindromeLinkedList {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    // head.next.next = new ListNode(1);
    //head.next.next.next = new ListNode(1);
    LinkedList linkedList = new LinkedList(head);
    boolean result = linkedList.isPalindrome();
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

    private ListNode head;


    private LinkedList(ListNode head) {
      this.head = head;
    }


    public boolean isPalindrome() {
      if (head.next == null) {
        return true;
      }
      if (head.next.next == null) {
        return head.val == head.next.val;
      }
      ListNode fast = head.next.next;
      ListNode slow = head;
      int count = 2;
      while (fast.next != null) {
        if (fast.next.next != null) {
          fast = fast.next.next;
          count += 2;
        } else {
          count++;
          fast = fast.next;
        }
        slow = slow.next;
      }
      count++;
      ListNode pointer = slow.next;
      ListNode tempNode = pointer;
      ListNode newNextNode = null;
      while (pointer.next != null) {
        ListNode tempPointer = pointer.next;
        pointer.next = newNextNode;
        newNextNode = pointer;
        pointer = tempPointer;
      }
      pointer.next = newNextNode;
      if (count % 2 != 0) {
        tempNode = pointer.next;
      }
      while (pointer != null) {
        if (pointer.val != head.val) {
          return false;
        }
        pointer = pointer.next;
        head = head.next;
      }
      return true;
    }
  }
}
