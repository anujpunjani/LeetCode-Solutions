/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null) return null; 
        
        ListNode slow = head;
        ListNode fast = head;
        
        do {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        } while(slow != null && fast != null && slow != fast);
        
        if(slow == fast) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            
            return slow;
        }
        
        return null;
    }
}