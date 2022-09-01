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
    
    ListNode reverse(ListNode head)
    {
        ListNode prev = null, curr = head;
        
        while(curr != null) {
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        
        return prev;
    }
    
    private int size(ListNode head) {
        int i = 0;
        while(head != null) {
            i++;
            head = head.next;
        }
        return i;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null || k == 0) return head;
        
        int count = 1;
        ListNode prev = head;
        ListNode curr = head;
        
        int size = size(head);
        k = size - k % size;
        
        while(curr != null && count < k) {
            count++;
            curr = curr.next;
        }
        
        ListNode ahead = curr.next;
        curr.next = null;
        
        ListNode first = reverse(head);
        ListNode second = reverse(ahead);
        head.next = second;
        
        return reverse(first);
    }
}