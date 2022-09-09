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

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while(fast != null && k --> 1)
            fast = fast.next;
        
        ListNode fromStart = fast;
        
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        int temp = fromStart.val;
        fromStart.val = slow.val;
        slow.val = temp;
        
        return head;
    }
}