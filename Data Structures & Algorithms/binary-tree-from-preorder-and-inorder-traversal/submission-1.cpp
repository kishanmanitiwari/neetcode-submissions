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
    TreeNode* buildTreeHelper(vector<int> preorder, int preStart, int preEnd, vector<int> inorder,
                              int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return nullptr;  // boundary condition, if we have crossed the limits of the
                             // array, return null
        }

        int rootVal = preorder[preStart];  // The first element in preorder is the root
        auto root = new TreeNode(rootVal);

        // Find the index of the root in inorder array
        auto it = find(inorder.begin() + inStart, inorder.begin() + inEnd + 1, rootVal);

        int rootIndexInInorder = it - inorder.begin();  // Get the index of rootVal in inorder array

        // 1. Correct the size definitions (using explicit int for consistency)
        int leftSubtreeSize = rootIndexInInorder - inStart;

        // 3. The recursive calls (Your structural indexing here is correct)
        root->left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder,
                                     inStart, rootIndexInInorder - 1);

        root->right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder,
                                      rootIndexInInorder + 1, inEnd);

        return root;
    }

    TreeNode* buildTree(vector<int> preorder, vector<int> inorder) {
        return buildTreeHelper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
    }
};
