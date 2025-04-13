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
    private int number = 0;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return number;
    }

    private void dfs(TreeNode root){
        if(root.left != null){
            dfs(root.left);
        }
        count--;

        if(count == 0){
            number = root.val;
            return;
        }
        if(root.right != null){
            dfs(root.right);
        }
    }
}