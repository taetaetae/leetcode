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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> totalList = new ArrayList();
        if(root == null){
            return totalList;
        }
        queue.add(root);
        while(queue.size() > 0) {
            int levelSize = queue.size();
            List<Integer> nodes = new ArrayList<>();

            for(int i=0 ; i<levelSize ; i++){
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
                nodes.add(treeNode.val);
            }

            totalList.add(nodes);
        }
        return totalList;
    }
}