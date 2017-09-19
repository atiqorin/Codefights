class HasDeadlock {
    public static boolean deadLock;

    boolean hasDeadlock(int[][] connections) {
        int n = connections.length;
        deadLock = false;
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < connections[i].length; j++) {
                adj[i].add(connections[i][j]);
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            dfs(adj, i, set);
            if (deadLock) {
                return true;
            }
        }
        return false;
    }

    void dfs(ArrayList<Integer>[] adj, int node, HashSet<Integer> set) {
        if (deadLock) {
            return;
        }
        if (set.contains(node)) {
            deadLock = true;
            return;
        }
        set.add(node);
        for (int i : adj[node]) {
            dfs(adj, i, set);
        }
        set.remove(node);
    }
}