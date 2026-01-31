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
    public static int sumOfLeftLeaves(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;
        boolean isLeftNode = false;
        while (!stack.empty()) {
            var node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                isLeftNode = false;
            }

            if (node.left != null) {
                stack.push(node.left);
                isLeftNode = true;
            }
            else if (isLeftNode) {
                sum += node.val; // left leaf
                isLeftNode = false;
            }
        }

        return sum;
    }

}