class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode pointer = newHead;
        int curSum = 0;
        while(l1 != null || l2 != null || curSum != 0) {
            if(l1 != null) {
                curSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                curSum += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(curSum % 10);
            curSum /= 10;
            pointer = pointer.next;
        }
        return newHead.next;
    }
}
