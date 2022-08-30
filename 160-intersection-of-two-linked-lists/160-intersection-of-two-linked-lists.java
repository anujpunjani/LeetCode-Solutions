/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        
        ListNode A = headA, B = headB;
        
        while(A != null) {
            countA++;
            A = A.next;
        }
        
        while(B != null) {
            countB++;
            B = B.next;
        }
        
        int diff = Math.abs(countA - countB);
        
        if(countA > countB)
            while(diff --> 0)
                headA = headA.next;
        else
            while(diff --> 0)
                headB = headB.next;
        
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}