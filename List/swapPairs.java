/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummyHead = dummy;
        while(dummyHead.next != null && dummyHead.next.next != null) {
            ListNode first = dummyHead.next;
            ListNode second = dummyHead.next.next;
            first.next= second.next;
            second.next = first;
            dummyHead.next = second;
            dummyHead = dummyHead.next.next;
        }
        return dummy.next;
    }
}
