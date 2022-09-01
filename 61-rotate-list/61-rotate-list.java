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
    
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;
        
        int count = 1, size = 1;
        ListNode tail = head;
        ListNode curr = head;
        
        while(tail.next != null) {
            size++;
            tail = tail.next;
        }
        
        k = k % size;
        
        if(k == 0) return head;
        
        while(count < size - k) {
            curr = curr.next;
            count++;
        }
        
        ListNode ahead = curr.next;
        curr.next = null;
        tail.next = head;
        return ahead;
    }
}