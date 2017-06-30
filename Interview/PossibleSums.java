class PossibleSums {
    HashSet<Integer> set;

    int possibleSums(int[] coins, int[] quantity) {
        set = new HashSet<>();
        solve(coins, quantity, 0, 0);

        return set.size() - 1;
    }

    void solve(int[] coins, int[] quantity, int index, int currentsum) {
        if (index == coins.length) {
            set.add(currentsum);
            return;
        }

        for (int i = 0; i <= quantity[index]; ++i) {
            solve(coins, quantity, index + 1, currentsum);
            currentsum += coins[index];
        }
    }
}