class CountSmallerToTheRight {
    static int maxN = 20002;

    int[] countSmallerToTheRight(int[] nums) {
        int[] BIT = new int[maxN];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] += maxN / 2;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            PushBIT(BIT, nums[i] + 1);
            result[i] = GetBIT(BIT, nums[i]);
        }

        return result;
    }

    void PushBIT(int[] BIT, int i) {
        if (i < maxN) {
            BIT[i]++;
            PushBIT(BIT, i + (i & -i));
        }

    }

    int GetBIT(int[] BIT, int i) {
        if (i == 0) {
            return 0;
        }

        return BIT[i] + GetBIT(BIT, i - (i & -i));
    }
}