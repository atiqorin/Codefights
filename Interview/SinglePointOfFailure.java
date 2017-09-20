class SinglePointOfFailure {
    static int count;
    static int connected;
    static boolean[] vis;

    int singlePointOfFailure(int[][] connections) {
        count = 0;

        for (int i = 0; i < connections.length; i++) {
            dfsWithout(connections, i);
        }
        return count / 2;
    }

    void dfsWithout(int[][] conn, int n) {
        for (int i = 0; i < conn.length; i++) {
            if (conn[n][i] == 1) {
                conn[n][i] = 0;
                conn[i][n] = 0;
                connected = 0;
                vis = new boolean[conn.length];
                dfs(conn, n);
                conn[n][i] = 1;
                conn[i][n] = 1;
                if (connected < conn.length) {
                    count++;
                }
            }
        }
    }

    void dfs(int[][] conn, int n) {
        if (vis[n]) {
            return;
        }
        vis[n] = true;
        for (int i = 0; i < conn.length; i++) {
            if (i == n) {
                continue;
            }
            if (conn[n][i] == 1) {
                dfs(conn, i);
            }
        }
        connected++;
    }
}