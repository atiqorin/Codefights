class ReverseNodesInKGroups {
    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        ListNode<Integer> head = l;
        ListNode<Integer> curTail = l;
        ListNode<Integer> lastTail = null;
        ListNode<Integer> cur = l;
        ListNode<Integer> next = null;
        ListNode<Integer> prev = null;
        ListNode<Integer> counter = l;

        int count = 0;
        int total = 0;
        int num = 0;
        while (counter != null) {
            total++;
            counter = counter.next;
        }

        while (cur != null) {
            num++;
            count++;

            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

            if (count == 1) {
                curTail = prev;
            }
            if (count == k) {
                curTail.next = cur;
                count = 0;

                if (lastTail == null) {
                    head = prev;
                } else {
                    lastTail.next = prev;
                }
                prev = null;
                lastTail = curTail;
                curTail.next = cur;
                if (total - num < k) {
                    break;
                }
            }

        }
        return head;
    }
}