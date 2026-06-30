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
    List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return List.of();

        var result = new ArrayList<Integer>();
        var q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            var levelSize = q.size(); // Number of nodes at the current level

            for (var i = 1; i <= levelSize; i++) {
                var node = q.poll();

                if (i == levelSize) {
                    result.add(node.val);
                }

                // Push children to the queue for the next level
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return result;
    }
}
