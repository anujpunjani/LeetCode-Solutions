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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode beforea = null, afterb = null, curr = list1;
        
        while(curr != null && curr.next != null) {
            if(--a == 0) beforea = curr;
            if(b-- == 0) afterb = curr.next;
            
            curr = curr.next;
        }
        
        curr = list2;
        while(curr.next != null) curr = curr.next;
        curr.next = afterb;
        beforea.next = list2;
        
        return list1;
    }
}