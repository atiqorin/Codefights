class HouseRobber {
    public static int[] dp;

    int houseRobber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = nums[0] + rob(2, nums);
        ans = Math.max(ans, rob(1, nums));
        return ans;
    }

    int rob(int i, int[] nums) {
        if (i >= dp.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = nums[i] + rob(i + 2, nums);
        ans = Math.max(ans, rob(i + 1, nums));
        dp[i] = ans;
        return ans;
    }
}