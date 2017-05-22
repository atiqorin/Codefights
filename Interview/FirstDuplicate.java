class FirstDuplicate {
    int firstDuplicate(int[] a) {
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {
                ans = i;
                break;
            } else {
                set.add(a[i]);
            }
        }
        if (ans == -1) {
            return ans;
        }
        return a[ans];
    }
}