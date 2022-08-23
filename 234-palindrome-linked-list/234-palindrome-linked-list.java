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
    
    ListNode mid(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        
        while(curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = mid(head);
        ListNode midNext = reverse(midNode.next);
        midNode.next = null;
        
        while(head != null && midNext != null) {
            if(head.val != midNext.val) return false;
            
            head = head.next;
            midNext = midNext.next;
        }
        
        return true;
    }
}