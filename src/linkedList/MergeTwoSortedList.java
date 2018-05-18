package linkedList;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/
public class MergeTwoSortedList {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    ListNode result = process(l1, l2);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }

  private static ListNode process(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    if (l1.val > l2.val) {
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;

    }
    l1.next = process(l1.next, l2);
    return l1;
  }

  private static class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }
}
