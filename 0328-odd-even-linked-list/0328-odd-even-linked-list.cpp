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
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        ListNode* odd = new ListNode(), *oddTail = odd;
        ListNode* even = new ListNode(), *evenTail = even;
        
        bool position = true;
        while(head != nullptr) {
            if(position) {
                oddTail->next = head;
                oddTail = head;        
            } else {
                evenTail->next = head;
                evenTail = head;
            }
            
            position = !position;
            head = head->next;
        }
        
        evenTail->next = nullptr;
        oddTail->next = even->next;
        
        return odd->next;
    }
};