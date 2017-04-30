class NextLarger {
    int[] nextLarger(int[] a) {
        int len = a.length;
        int[] ans = new int[len];

        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (int i = 0; i < len; i++) {
            int next = a[i];
            if (!stk.isEmpty()) {
                int cur = stk.pop();
                while (a[cur] < next) {
                    ans[cur] = next;
                    if (stk.isEmpty()) {
                        break;
                    }
                    cur = stk.pop();
                }
                if (a[cur] > next) {
                    stk.push(cur);
                }
            }
            stk.push(i);
        }
        while (!stk.isEmpty()) {
            int cur = stk.pop();
            ans[cur] = -1;
        }
        return ans;
    }
}