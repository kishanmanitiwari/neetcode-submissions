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
    List<Integer> postorderTraversal(TreeNode root) {
        var result = new ArrayList<Integer>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> result) {
        // base case
        if (root == null)
            return;

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}