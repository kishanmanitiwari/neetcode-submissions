/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
   public:
    int goodNodesHelper(TreeNode* root, int prevNodeVal) {
        if (!root) return 0;  // base case this is smallest case i can think of

        int current = 0;

        if (root->val >= prevNodeVal) {
            current = 1;
            prevNodeVal = root->val;
        }

        auto left = goodNodesHelper(root->left, prevNodeVal);    // rec give me left
        auto right = goodNodesHelper(root->right, prevNodeVal);  // recursion give me of right

        return current + left + right;
    }
    int goodNodes(TreeNode* root) {
        return goodNodesHelper(root, root->val);
    }
};
