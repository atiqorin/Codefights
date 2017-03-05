class ComposeRanges {
    String[] composeRanges(int[] nums) {
        if (nums.length == 0) {
            return new String[0];
        }
        int left = 0;
        int right = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                right++;
            } else {
                list.add(getRange(nums[left], nums[right]));
                left = i;
                right = i;
            }
        }
        list.add(getRange(nums[left], nums[right]));
        return list.toArray(new String[0]);
    }

    String getRange(int l, int r) {
        if (l == r) {
            return "" + l;
        } else {
            return "" + l + "->" + r;
        }
    }
}