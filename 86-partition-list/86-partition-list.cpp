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
    ListNode* partition(ListNode* head, int x) {
        ListNode* dummy1 = new ListNode(), *tail1 = dummy1;
        ListNode* dummy2 = new ListNode(), *tail2 = dummy2;
        
        while(head) {
            if(head->val < x) {
                tail1->next = head;
                tail1 = head;
            } else {
                tail2->next = head;
                tail2 = head;                
            }
            head = head->next;
        }
        
        tail1->next = dummy2->next;
        tail2->next = nullptr;
        
        return dummy1->next;
    }
};