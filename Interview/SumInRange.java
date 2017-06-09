class SumInRange {
    int sumInRange(int[] nums, int[][] queries) {
        int[] cumulative = new int[nums.length];
        cumulative[0] = nums[0];
        for(int i = 1; i < cumulative.length; i++){
            cumulative[i] = nums[i] + cumulative[i-1];
        }
        long sum = 0;
        for(int[] q : queries){
            if(q[0] == 0){
                sum += cumulative[q[1]];
            } else {
                sum += cumulative[q[1]] - cumulative[q[0] - 1];
            }
        }
        int ans = (int)(sum % 1000000007);
        if(ans < 0){
            ans += 1000000007;
        }
        return ans;
    }
}
