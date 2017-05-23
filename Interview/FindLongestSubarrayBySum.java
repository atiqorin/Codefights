class FindLongestSubarrayBySum {
    int[] findLongestSubarrayBySum(int s, int[] arr) {
        long[] prf = new long[arr.length + 1];
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            prf[i + 1] = sum;
            map.put(prf[i + 1], i);
        }
        int left = -1;
        int right = -1;
        for (int i = 0; i < prf.length; i++) {
            Integer mapVal = map.get(prf[i] + s);
            if (mapVal != null) {
                if (left == -1 && right == -1) {
                    left = i + 1;
                    right = mapVal + 1;
                } else {
                    if (right - left + 1 < mapVal - i + 1) {
                        left = i + 1;
                        right = mapVal + 1;
                    }
                }
            }
        }
        if (left != -1 && right != -1) {
            return new int[] { left, right };
        }
        return new int[] { -1 };
    }
}