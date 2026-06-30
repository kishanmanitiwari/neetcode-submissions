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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        // temp node pattern technique
        ListNode* temp1 = list1;
        ListNode* temp2 = list2;
        ListNode* dummy = new ListNode(0);
        ListNode* trackDummy = dummy;

        while (temp1 and temp2) {
            if (temp1->val <= temp2->val) {
                dummy->next = temp1;
                temp1 = temp1->next;
            } else {
                dummy->next = temp2;
                temp2 = temp2->next;
            }
            dummy = dummy->next;
        }

        dummy->next = temp1 ? temp1 : temp2;

        return trackDummy->next;
    }
};
