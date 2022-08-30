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
    
    private ListNode getmid(ListNode node) {
        ListNode slow = node, fast = node;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode mid = getmid(head);
        
        if(mid.next == null) {
            head.next = null;
            return head;
        }
        
        mid.val = mid.next.val;
        mid.next = mid.next.next;
        
        return head;
    }
}