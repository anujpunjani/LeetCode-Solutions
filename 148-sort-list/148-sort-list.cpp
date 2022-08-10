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
    
    ListNode* middle(ListNode* head) {
        ListNode* fast = head->next, *slow = head;
        
        while(fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        
        return slow;
    }
    
    ListNode* merge2LL(ListNode* head1, ListNode* head2) {
        
        ListNode* dummy = new ListNode();
        ListNode* tail = dummy;
        
        while(head1 != nullptr && head2 != nullptr) {
            if(head1->val < head2->val) {
                tail->next = head1;
                tail = head1;
                head1 = head1->next;
            } else {
                tail->next = head2;
                tail = head2;
                head2 = head2->next;
            }
        }
        
        if(head1) tail->next = head1;
        else tail->next = head2;
        
        return dummy->next;
    }
    
    ListNode* sortList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head;
        
        ListNode* mid = middle(head);
        ListNode* midNext = mid->next;
        mid->next = nullptr;
        
        ListNode* left = sortList(head);
        ListNode* right = sortList(midNext);
        
        return merge2LL(left, right);
    }
};