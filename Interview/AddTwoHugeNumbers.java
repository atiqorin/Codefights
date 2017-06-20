class AddTwoHugeNumbers {
    // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        a = reverse(a);
        b = reverse(b);
        int carry = 0;
        ListNode<Integer> ans = new ListNode<>(0);
        ListNode<Integer> ansHead = ans;
        while (a != null || b != null) {
            int cur = carry;
            if (a != null) {
                cur += a.value;
                a = a.next;
            }
            if (b != null) {
                cur += b.value;
                b = b.next;
            }
            carry = cur / 10000;
            cur %= 10000;
            ans.value += cur;
            if (carry > 0 || a != null || b != null) {
                ans.next = new ListNode<>(0);
                ans = ans.next;
            }
        }
        if (carry > 0) {
            ans.value = carry;
        }

        return reverse(ansHead);
    }

    ListNode<Integer> reverse(ListNode<Integer> l) {
        ListNode<Integer> prev = null;
        ListNode<Integer> cur = l;
        ListNode<Integer> next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}