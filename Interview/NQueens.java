class NQueens {
    static ArrayList<ArrayList<Integer>> list;

    int[][] nQueens(int n) {
        int[] rows = new int[n];
        list = new ArrayList<>();
        backtrack(0, n, rows);

        int[][] res = new int[list.size()][n];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                res[i][j] = list.get(i).get(j) + 1;
            }
        }
        return res;
    }

    void backtrack(int c, int n, int[] rows) {
        if (c == n) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int r : rows) {
                rowList.add(r);
            }
            list.add(rowList);
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, c, rows)) {
                rows[c] = i;
                backtrack(c + 1, n, rows);
            }
        }
    }

    boolean isSafe(int r, int c, int[] rows) {
        for (int i = 0; i < c; i++) {
            if (r == rows[i] || Math.abs(r - rows[i]) == Math.abs(c - i)) {
                return false;
            }
        }
        return true;
    }
}