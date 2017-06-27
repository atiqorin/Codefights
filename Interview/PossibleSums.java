class PossibleSums {
    int possibleSums(int[] coins, int[] quantity) {
        int max = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < quantity[i]; j++) {
                max += coins[i];
            }
        }
        int[] arr = new int[coins.length + 1];
        for (int i = 0; i < coins.length; i++) {
            arr[i + 1] = coins[i];
        }
        int[][] isPossible = new int[coins.length + 1][max + 1];
        for (int i = 0; i < arr.length; i++) {
            isPossible[i][0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= max; j++) {
                for (int k = 0; k <= quantity[i - 1]; k++) {
                    if (j - k * arr[i] >= 0 && isPossible[i - 1][j - k * arr[i]] == 1) {
                        isPossible[i][j] = 1;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= max; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (isPossible[i][j] == 1) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}