function longestIncreasingSubsequence(sequence) {
    var LIS = Array(sequence.length).fill(1);
    for(var i = 1; i < sequence.length; i++) {
        LIS[i] = 1;
        for(var j = 0; j < i; j++) {
            if(sequence[j] < sequence[i] && LIS[i] < LIS[j] + 1) {
                LIS[i] = LIS[j] + 1;
            }
        }
    }
    return Math.max(...LIS);
}
