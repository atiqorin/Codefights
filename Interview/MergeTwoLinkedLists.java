class MergeTwoLinkedLists {
    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode<Integer> n = new ListNode<Integer>(0);
        ListNode<Integer> head = n;
        ListNode<Integer> prev = n;
        while (l1 != null || l2 != null) {
            if (n == null) {
                n = new ListNode<Integer>(0);
            }
            if (l1 != null && l2 != null) {
                if (l1.value < l2.value) {
                    n.value = l1.value;
                    l1 = l1.next;
                } else {
                    n.value = l2.value;
                    l2 = l2.next;
                }
            } else if (l1 != null) {
                n.value = l1.value;
                l1 = l1.next;
            } else if (l2 != null) {
                n.value = l2.value;
                l2 = l2.next;
            }
            n.next = new ListNode<Integer>(0);
            prev = n;
            n = n.next;
        }

        prev.next = null;
        return head;
    }
}