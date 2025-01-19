/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
    문제가 이해가 안되지만...
    계속 순회하면서 순환이 되는 리스트인지를 확인하는 문제.
    next Node가 있었다면 true, 끝까지 갔는데 없으면 false
    */
    // Set<Integer> nodeVals = new HashSet();
    Set<ListNode> nodes = new HashSet();

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        if(nodes.contains(head)){
            return true;
        }
        if(head.next == null){
            return false;
        }

        nodes.add(head);
        return hasCycle(head.next);
    }
}