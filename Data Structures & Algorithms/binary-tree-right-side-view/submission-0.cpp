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
    using vi = vector<int>;
    using pi = pair<int, int>;

   public:
    vector<int> rightSideView(TreeNode* root) {
        if (!root) return {};  // Handle empty tree

        vi result;
        queue<TreeNode*> q;
        q.push(root);

        while (!q.empty()) {
            int levelSize = q.size();  // Number of nodes at the current level

            for (int i = 1; i <= levelSize; i++) {
                auto node = q.front();
                q.pop();

                if (i == levelSize) {
                    result.push_back(node->val);
                }

                // Push children to the queue for the next level
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
        }

        return result;
    }
};
