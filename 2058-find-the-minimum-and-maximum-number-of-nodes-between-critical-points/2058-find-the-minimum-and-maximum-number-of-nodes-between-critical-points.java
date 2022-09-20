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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int criticalPoints = 0;
        int prevPoint = 0, currentPoint = 0, firstPoint = 0;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        ListNode prev = head, cNode = head;
        cNode = cNode.next;
        
        int count = 1;
        
        while(cNode != null && cNode.next != null) {
            if(prev.val < cNode.val && cNode.val > cNode.next.val) {
                criticalPoints++;
                prevPoint = currentPoint;
                currentPoint = count;
                if(firstPoint == 0) firstPoint = count;
            }
            
            if(prev.val > cNode.val && cNode.val < cNode.next.val) {
                criticalPoints++;
                prevPoint = currentPoint;
                currentPoint = count;
                if(firstPoint == 0) firstPoint = count;
            }
            
            if(criticalPoints >= 2){
                min = Math.min(min, currentPoint - prevPoint);
                max = Math.max(max, currentPoint - firstPoint);
            }
            
            count++;
            prev = cNode;
            cNode = cNode.next;
        }
        
        return criticalPoints < 2? new int[]{-1, -1} : new int[]{min, max};
    }
}