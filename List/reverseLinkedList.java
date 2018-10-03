public class reverseLinkedList {
    public void reverseList(ListNode node) {
        //O(n) time complexity, O(1) space complexity.
        if(node == null) return;
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode root = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return root;
    }
}
