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
    private int preIndex = 0;
    private Map<Integer, Integer> inIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0 ; i<inorder.length ; i++){
            inIndexMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int inStart, int inEnd){
        if (inStart > inEnd){
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inIndexMap.get(rootVal);

        root.left = buildSubTree(preorder, inStart, rootIndex - 1);
        root.right = buildSubTree(preorder, rootIndex+1, inEnd);

        return root;
    }    
}