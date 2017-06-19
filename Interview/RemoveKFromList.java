class RemoveKFromList {
    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> helper = new ListNode<>(0);
        helper.next = l;
        ListNode<Integer> p = helper;
        while (p.next != null) {
            if (p.next.value == k) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return helper.next;
    }
}