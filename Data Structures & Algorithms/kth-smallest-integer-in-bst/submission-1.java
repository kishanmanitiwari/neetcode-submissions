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
    public void kthSmallestHelper(TreeNode root, int[] kArr, int[] ans) {
        if (root == null)
            return;

        kthSmallestHelper(root.left, kArr, ans);
        kArr[0]--;
        if (kArr[0] == 0) {
            ans[0] = root.val;
            return;
        }
        kthSmallestHelper(root.right, kArr, ans);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[] {-1};
        int[] kArr = new int[] {k};
        kthSmallestHelper(root, kArr, ans);
        return ans[0];
    }
}
