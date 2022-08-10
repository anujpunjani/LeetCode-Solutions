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
    
    ListNode merge2LL(ListNode head1, ListNode head2) {
        
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        
        if(head1 != null) tail.next = head1;
        else tail.next = head2;
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode merge = null;
        
        for(int i = 0; i < lists.length; i++) {
            
            merge = merge2LL(lists[i], merge);
            
        }
        
        return merge;
    }
}