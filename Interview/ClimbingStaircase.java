int[][] climbingStaircase(int n, int k) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    solve(n, k, result, new ArrayList<Integer>());
    int[][] ans = new int[result.size()][0];
    for(int i = 0; i < result.size(); i++) {
        ans[i] = new int[result.get(i).size()];
        for(int j = 0; j <ans[i].length; j++) {
            ans[i][j] = result.get(i).get(j);
        }
    }
    return ans;
}
void solve(int n, int k, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
    if(n == 0) {
        result.add(new ArrayList<>(temp));
    }
    
    for(int i = 1; i <= k; i++) {
        if(i <= n) {
            temp.add(i);
            solve(n-i, k, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
