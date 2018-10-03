class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode greater = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode greaterPointer = greater;
        ListNode smallerPointer = smaller;
        while(head != null) {
            System.out.println(head.val);
            if(head.val < x) {
                smallerPointer.next = head;
                smallerPointer = smallerPointer.next;
            } else {
                greaterPointer.next = head;
                greaterPointer = greaterPointer.next;
            }
            head = head.next;
        }
        smallerPointer.next = greater.next;
        greaterPointer.next = null;        
        return smaller.next;
    }
}
