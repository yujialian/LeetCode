class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummyPointer = dummy;
        while(dummyPointer.next != null) {
            if(dummyPointer.next.val == val) {
                ListNode remain = dummyPointer.next.next;
                dummyPointer.next.next = null;
                dummyPointer.next = remain;
            } else {
                dummyPointer = dummyPointer.next;
            }
        }
        return dummy.next;
    }
}
