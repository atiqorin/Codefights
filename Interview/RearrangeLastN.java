class RearrangeLastN {
        // Definition for singly-linked list:
    // class ListNode<T> {
    //   ListNode(T x) {
    //     value = x;
    //   }
    //   T value;
    //   ListNode<T> next;
    // }
    //
    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        ListNode<Integer> head = l;
        ListNode<Integer> mid = l;
        ListNode<Integer> prev = l;
        ListNode<Integer> midPrev = null;
        if(n == 0){
            return l;
        }
        int count = 0;
        while(l != null){
            count++;
            if(count > n){
                midPrev = mid;
                mid = mid.next;
            }
            prev = l;
            l = l.next;
        }
        if(midPrev != null){
            prev.next = head;
            head = mid;
            midPrev.next = null;
        }
        
        return head; 
    }
}