class MissingNumber {
    int missingNumber(int[] arr) {
        int len = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(arr[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= len; i++) {
            if (!set.contains(i)) {
                ans = i;
            }
        }
        return ans;
    }
}