/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
   public void reorderList(ListNode head) {
    // plan is to find the middle of the linked list, reverse the second half and
    // then merge the two halves together
    // eg 2 -> 4 -> 6 -> 8
    // mid is 6, so we reverse the second half to get 8 -> 6 and then we merge the
    // two halves to get 2 -> 8 -> 4 -> 6

    if (head == null || head.next == null) {
      return;
    }

    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // slow is now at the middle of the linked list
    ListNode secondHalf = reverse(slow.next);
    slow.next = null; // break the linked list into two halves

    ListNode firstHalf = head;
    while (secondHalf != null) {
      ListNode temp1 = firstHalf.next;
      ListNode temp2 = secondHalf.next;

      firstHalf.next = secondHalf;
      secondHalf.next = temp1;

      firstHalf = temp1;
      secondHalf = temp2;
    }
  }

  private ListNode reverse(ListNode next) {
    ListNode prev = null, current = next;
    while (current != null) {
      ListNode temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    return prev; // new head of the reversed linked list
  }
}
