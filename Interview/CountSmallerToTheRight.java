class CountSmallerToTheRight {
    int[] countSmallerToTheRight(int[] nums) {
        if (nums.length == 0) {
            return new int[] {};
        }
        if (nums.length == 1) {
            return new int[] { 0 };
        }
        int cut = nums.length / 2;
        int toEnd = nums.length - cut;
        int[] left = new int[cut];
        int[] right = new int[toEnd];
        for (int i = 0; i < cut; i++) {
            left[i] = nums[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[i + cut];
        }
        int[] l = countSmallerToTheRight(left);
        int[] r = countSmallerToTheRight(right);

        for (int i = l.length - 1; i >= 0; i--) {
            for (int j = 0; j < r.length; j++) {
                if (nums[i] > nums[cut + j]) {
                    l[i] += 1;

                }
            }
        }
        int[] count = new int[nums.length];
        for (int i = 0; i < l.length; i++) {
            count[i] = l[i];
        }
        for (int i = 0; i < r.length; i++) {
            count[cut + i] = r[i];
        }

        return count;
    }
}