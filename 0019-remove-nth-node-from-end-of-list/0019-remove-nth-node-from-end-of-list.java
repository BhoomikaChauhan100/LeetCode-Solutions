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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // fast ko n steps aage leke jana h
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // agar fast null ho gaya toh head delete karna hai
        if(fast == null) {
            return head.next;
        }

        // dono ko move karna
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // delete node
        slow.next = slow.next.next;

        return head;
    }
}