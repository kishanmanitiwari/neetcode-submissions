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
    private void inorderTraversalHelper(TreeNode root, ArrayList<Integer> result) {
        // base case
        if (root == null)
            return;

        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }

    List<Integer> inorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        inorderTraversalHelper(root, result);
        return result;
    }
}