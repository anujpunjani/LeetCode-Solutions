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
    
    ListNode helper(ListNode[] lists, int left, int right) {
        if(left == right) return lists[left];
        
        int mid = left + (right - left)/2;
        ListNode first = helper(lists, left, mid);
        ListNode second = helper(lists, mid + 1, right);
        
        return merge2LL(first, second);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
}