class ClimbingStairs {
    static int[] dp;

    int climbingStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(n, 0);
    }

    int climb(int n, int i) {
        if (n == i) {
            return 1;
        }
        if (i > n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = climb(n, i + 1);
        ans += climb(n, i + 2);
        dp[i] = ans;
        return ans;
    }
}