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
    
    ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;
        while(curr != null) {
            
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    public int getDecimalValue(ListNode head) {
        head = reverse(head);
        
        int power = 1;
        int ans = 0;
        
        while(head != null) {
            ans += power*head.val;
            head = head.next;
            power *= 2;
        }
        
        return ans;
    }
}