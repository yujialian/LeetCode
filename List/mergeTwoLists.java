class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode dummyP = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                dummyP.next = l2;
                l2 = l2.next;
            } else {
                dummyP.next = l1;
                l1 = l1.next;
            }
            dummyP = dummyP.next;
        }
        if(l1 != null) {
            dummyP.next = l1;
        }
        if(l2 != null) {
            dummyP.next = l2;
        }
        return dummy.next;
    }
}
