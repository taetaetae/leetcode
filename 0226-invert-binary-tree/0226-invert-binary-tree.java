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
   public TreeNode invertTree(TreeNode root) {
    /*
    이진트리를 좌우로 뒤집기

    재귀로 하고, 루트 노드의 좌/우를 교체하고 다음으로 넘어가는 흐름
    next가 없을 경우 부모노드 리턴
     */

    if (root == null) {
      return null;
    }

    TreeNode left = root.left;
    TreeNode right = root.right;
    root.right = left;
    root.left = right;

    if (root.right != null) {
      invertTree(root.right);
    }
    if(root.left!= null) {
      invertTree(root.left);
    }
    return root;
  }
}