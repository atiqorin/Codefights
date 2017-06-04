class IsListPalindrome {
    // Definition for singly-linked list:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    boolean isListPalindrome(ListNode<Integer> l) {
        if (l == null || l.next == null) {
            return true;
        }
        ListNode<Integer> mid = null;
        ListNode<Integer> fast = l;
        ListNode<Integer> slow = l;
        ListNode<Integer> secondHead = null;
        boolean ans = true;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        secondHead = slow.next;
        slow.next = null;

        ListNode<Integer> p1 = secondHead;
        ListNode<Integer> p2 = p1.next;

        while (p1 != null && p2 != null) {
            ListNode<Integer> temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        secondHead.next = null;

        ListNode<Integer> p = (p2 == null ? p1 : p2);
        ListNode<Integer> q = l;
        while (p != null) {
            if (!p.value.equals(q.value)) {
                return false;
            }
            p = p.next;
            q = q.next;

        }
        return true;
    }
}