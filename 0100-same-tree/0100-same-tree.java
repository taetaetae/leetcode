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
    public boolean isSameTree(TreeNode p, TreeNode q) {
    List<Integer> pValues = new ArrayList<>();
    List<Integer> qValues = new ArrayList<>();

    tourTree(p, pValues);
    tourTree(q, qValues);

    if (pValues.size() != qValues.size()) {
      return false;
    }
    for (int i = 0; i < pValues.size(); i++) {
      Integer pValue = pValues.get(i);
      Integer qValue = qValues.get(i);
      if (!Objects.equals(pValue, qValue)) {
        return false;
      }
    }

    return true;
  }

  public TreeNode tourTree(TreeNode node, List values) {
    if (node == null) {
      return null;
    }

    values.add(node.val);
    if (node.left != null) {
      tourTree(node.left, values);
    }
    if (node.right != null) {
      if (node.left == null) {
        values.add(null);
      }
      tourTree(node.right, values);
    }

    return null;
  }
}