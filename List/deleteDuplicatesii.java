class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode pointer = head;
        while(pointer != null) {
            map.put(pointer.val, map.getOrDefault(pointer.val, 0) + 1);
            pointer = pointer.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummyPointer = dummy;
        while(dummyPointer != null) {
            while(dummyPointer.next != null && map.get(dummyPointer.next.val) > 1) {
                ListNode remain = dummyPointer.next.next;
                dummyPointer.next.next = null;
                dummyPointer.next = remain;
            }
            dummyPointer = dummyPointer.next;
        }
        return dummy.next;
    }
}
