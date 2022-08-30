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
    
    private ListNode merge2LL(ListNode head1, ListNode head2) {
        
        ListNode dummy = new ListNode(), tail = dummy;
        
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
                tail = tail.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
                tail = tail.next;
            }
        }
        
        tail.next = head1 != null? head1 : head2;
        
        return dummy.next;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        
        ListNode first = sortList(head);
        ListNode second = sortList(midNext);
        
        return merge2LL(first, second);
    }
}