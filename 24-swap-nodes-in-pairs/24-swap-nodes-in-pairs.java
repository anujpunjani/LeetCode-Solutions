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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(), tail = dummy;
        ListNode prev = head;
        
        while(head != null && head.next != null) {
            ListNode ahead = head.next.next;
            ListNode next = head.next;
            
            head.next.next = head;
            head.next = null;
            tail.next = next;
            tail = head;
            
            head = ahead;
        }
        
        tail.next = head;
        
        return dummy.next;
    }
}