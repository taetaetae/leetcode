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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
          List<Integer> values = new ArrayList<>();
    while (list1 != null) {
      values.add(list1.val);
      list1 = list1.next;
    }
    while (list2 != null) {
      values.add(list2.val);
      list2 = list2.next;
    }

    Collections.sort(values);
    ListNode result = null;
    ListNode firstNode = null;
    for (Integer value : values) {
      if (result == null) {
        result = new ListNode(value, null);
        firstNode = result;
      } else {
        result.next = new ListNode(value, null);
        result = result.next;
      }
    }

    return firstNode;
    }
}