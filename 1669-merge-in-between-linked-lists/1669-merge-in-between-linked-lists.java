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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    /*
    두 리스트 노트가 주어지고
    첫번째 리스트 노드에서 a 번째 부터 b 번째를 두번째 리스트 노드로 교체하라는 문제

    a는 1보다 크니 결국 첫번째 리스트의 헤드를 리턴하면 될것 같고.

    a-1 번째를 찾고, b+1 번째를 찾아서

    a -1 번째의 next를 두번째 리스트로 갈아 끼우고
    두번째 리스트의 마지막 노드의 next를 b+1 번째로 교체
     */

    ListNode seekNode = list1;
    ListNode headNode = null, tailNode = null;

    int index = 0;
    while (seekNode.next != null) {
      if (index == a - 1) {
        headNode = seekNode;
      } else if (index == b) {
        tailNode = seekNode.next;
      }
      seekNode = seekNode.next;
      index++;
    }

    if (tailNode == null) {
      tailNode = seekNode.next;
    }

    headNode.next = list2;

    seekNode = list2;
    while (seekNode.next != null) {
      seekNode = seekNode.next;
    }
    seekNode.next = tailNode;
    return list1;
  }
}