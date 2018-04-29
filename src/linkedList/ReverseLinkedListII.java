package linkedList;

//https://leetcode.com/problems/reverse-linked-list-ii/description/
public class ReverseLinkedListII {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    LinkedList linkedList = new LinkedList(head);
    System.out.println("Original List:");
    ListNode current = linkedList.head;
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
    }
    int m = 2;
    int n = 3;

    linkedList.reverse(m, n);
    current = linkedList.head;
    System.out.println("Reverse List:");
    while (current != null) {
      System.out.println(current.val);
      current = current.next;
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

    ListNode head;

    public LinkedList(ListNode head) {
      this.head = head;
    }

    public void reverse(int m, int n) {
      if(m == n){
        return;
      }
      ListNode current = head;
      ListNode prev = null;
      for (int i = 1; current.next != null ; i++){
        if(m == i){
          ListNode beforeBreakPoint = prev;
          ListNode breakPoint = current;
          while (i <= n){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            i++;
          }
          breakPoint.next = current;
          if(beforeBreakPoint != null){
            beforeBreakPoint.next = prev;
          }else {
            head = prev;
          }
          break;
        }
        prev = current;
        current = current.next;
      }
    }
  }
}
