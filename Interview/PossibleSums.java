class PossibleSums {
    HashSet<Integer> set;
<<<<<<< HEAD

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
=======
    int possibleSums(int[] coins, int[] quantity) {
        set = new HashSet<>();
        int q=0;
        for(int i: quantity){
            q+=i;
        }
        for(int i = q; i > 0; i--){
            solve(coins, quantity, 0, i);
        }
        
        return set.size();
    }
    void solve(int[] coins, int[] quantity,int i, int q){
        if(q == 0){
            set.add(getSum(coins, quantity));
            return;
        } else if(i >= coins.length || q < 0){
            return;
        }
        int[] mod = Arrays.copyOf(quantity, quantity.length);
        for(int k = 1; mod[i] - k >= 0; k++){
            mod[i] -= k;
            solve(coins, mod, i, q - k);
            mod[i] += k;
        }
        solve(coins, quantity, i + 1, q);
    }
    int getSum(int[] coins, int[] quantity){
        int sum = 0;
        for(int i = 0; i < coins.length; i++){
            sum += coins[i] * quantity[i];
        }
        return sum;
>>>>>>> 6ccd5f4a4e9473aea9053ff4c04c602603ac7528
    }
}