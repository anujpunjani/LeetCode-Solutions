/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

#define null nullptr

class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* curr = head;
        ListNode* prevList = null;
        int temp = left;
        right = right - left + 1;
        
        while(temp --> 1) {
            prevList = curr;
            curr = curr->next;            
        }
        
        ListNode* prev = null, *ahead = null;
        ListNode* currList = curr;
        
        while(curr != null && right --> 0) {
            ahead = curr->next;
            curr->next = prev;
            prev = curr;
            curr = ahead;
        }
        
        if(prevList)
            prevList->next = prev;
        currList->next = ahead;

        return left == 1? prev: head;
    }
};