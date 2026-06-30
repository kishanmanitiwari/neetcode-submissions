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
        if (head == null || head.next == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode curr = head;
        int size = 0;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
            size++;
        }

        curr = head;

        for (int i = 0; i < size / 2; i++) {
            ListNode next = curr.next;
            ListNode last = stack.pop();

            curr.next = last;
            last.next = next;

            curr = next;
        }

        curr.next = null;
    }
}