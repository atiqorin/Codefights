class ProductExceptSelf {
    int productExceptSelf(int[] nums, int m) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int r = nums.length - 1;
        prefix[0] = 1;
        suffix[r] = 1;
        for (int i = 1; i <= r; i++) {
            prefix[i] = (prefix[i - 1] * nums[i - 1]) % m;
            suffix[r - i] = (suffix[r - i + 1] * nums[r - i + 1]) % m;
        }
        int total = 0;
        for (int i = 0; i <= r; i++) {
            total += (prefix[i] * suffix[i]) % m;
        }
        return total % m;
    }
}