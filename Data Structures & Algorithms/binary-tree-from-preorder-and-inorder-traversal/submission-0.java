/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(
        int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null; // boundary condition, if we have crossed the limits of the array, return
                         // null
        }

        int rootVal = preorder[preStart]; // The first element in preorder is the root
        var root = new TreeNode(rootVal);

        // Find the index of the root in inorder array
        int rootIndexInInorder = inStart;
        while (rootIndexInInorder <= inEnd && inorder[rootIndexInInorder] != rootVal) {
            rootIndexInInorder++;
        }

        // 1. Correct the size definitions (using explicit int for consistency)
        int leftSubtreeSize = rootIndexInInorder - inStart;

        // 3. The recursive calls (Your structural indexing here is correct)
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder,
            inStart, rootIndexInInorder - 1);

        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder,
            rootIndexInInorder + 1, inEnd);

        return root;
    }
}
