class ArrayMaxConsecutiveSum2 {
    int arrayMaxConsecutiveSum2(int[] inputArray) {
        int max_so_far = inputArray[0];
        int curr_max = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            curr_max = Math.max(inputArray[i], curr_max + inputArray[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}