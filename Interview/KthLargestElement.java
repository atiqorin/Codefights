class KthLargestElement {
    int kthLargestElement(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}