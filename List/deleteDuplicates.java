class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pointer = head;
        while(pointer != null && pointer.next != null) {
            ListNode then = pointer.next;
            while(then != null && pointer.val == then.val) {
                then = then.next;
            }
            pointer.next = then;
            pointer = pointer.next;
            
        }
        return head;
    }
}
