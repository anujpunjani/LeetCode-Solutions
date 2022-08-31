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
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while(head != null) {
            ListNode ahead = head.next;
            head.next = prev;
            prev = head;
            head = ahead;
        }
        
        return prev;
    } 
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(), tail = dummy;
        
        while(head != null) {
            
            ListNode curr = head, prev = head;
            int count = 0;
            while(curr != null && count < k) {
                count++;
                if(count < k)
                    curr = curr.next;
            }
            
            if(count < k) {
                tail.next = head;
                return dummy.next;
            }
            
            head = curr.next;
            curr.next = null;
            ListNode reversed = reverse(prev);
            tail.next = reversed;
            tail = prev;
        }
        
        return dummy.next;
    }
}