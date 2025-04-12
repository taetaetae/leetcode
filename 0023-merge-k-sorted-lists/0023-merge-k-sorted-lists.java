/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>( (a,b) -> a.val - b.val );

        for(ListNode listNode : lists){
            while(listNode != null){
                  System.out.println(listNode.val);
                pq.add(listNode);
                listNode = listNode.next;
            }
        }
        System.out.println("---");

        ListNode currentNode = pq.poll();
        ListNode resultNode = currentNode;
        while(!pq.isEmpty()){
            currentNode.next = pq.poll();
            currentNode = currentNode.next;
        }
        return resultNode;
    }
}