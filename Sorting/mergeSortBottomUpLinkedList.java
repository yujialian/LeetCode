/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mergeSortBottomUpLinkedList {
    public ListNode sortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        /*Check the head length.*/
        int n = 0;
        while(head != null) {
            n++;
            head = head.next;
        }
        ListNode pre, cur, left, right;
        for(int step = 1; step < n; step *= 2) {
            pre = fakeHead;
            cur = fakeHead.next;//Start from begining
            while(cur != null) {
                left = cur;
                right = split(left, step);
                cur = split(right, step);
                pre = merge(left, right, pre);
            }
        }
        return fakeHead.next;
    }
    
    private ListNode split(ListNode node, int n) {
        if(node == null) return null;
        for(int i = 0; node.next != null && i < n - 1; i++) node = node.next; //STOP ON LAST NODE
        ListNode right = node.next;
        node.next = null;
        return right;
    }
    private ListNode merge(ListNode left, ListNode right, ListNode last) {
        ListNode prev = last;
        while(left != null && right != null) {
            if(left.val > right.val) {
                prev.next = right;
                right = right.next;
            } else {
                prev.next = left;
                left = left.next;
            }
            prev = prev.next;
        }
        prev.next = (left != null ? left : right);
        while(prev.next != null) {
            prev = prev.next;
        }
        return prev;
    }
}
