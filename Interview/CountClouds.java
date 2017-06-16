class CountClouds {
    public static boolean[][] visited;

    int countClouds(char[][] skyMap) {
        if (skyMap.length == 0) {
            return 0;
        }
        visited = new boolean[skyMap.length][skyMap[0].length];
        int ans = 0;

        for (int i = 0; i < skyMap.length; i++) {
            for (int j = 0; j < skyMap[0].length; j++) {
                if (!visited[i][j] && skyMap[i][j] == '1') {
                    ans++;
                    System.out.println("qwe");
                    dfs(skyMap, i, j + 1);
                    dfs(skyMap, i, j - 1);
                    dfs(skyMap, i + 1, j);
                    dfs(skyMap, i - 1, j);
                }
            }
        }
        return ans;
    }

    void dfs(char[][] skyMap, int i, int j) {
        if (i < 0 || i >= skyMap.length || j < 0 || j >= skyMap[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (skyMap[i][j] == '0') {
            return;
        }

        dfs(skyMap, i, j + 1);
        dfs(skyMap, i, j - 1);
        dfs(skyMap, i + 1, j);
        dfs(skyMap, i - 1, j);
    }
}