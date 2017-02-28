class Sudoku2 {
    boolean sudoku2(char[][] grid) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            set.clear();
            for (char c : grid[i]) {
                if (c != '.' && set.contains(c)) {
                    return false;
                } else if (c != '.') {
                    set.add(c);
                }
            }
            set.clear();
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != '.' && set.contains(grid[j][i])) {
                    return false;
                } else if (grid[j][i] != '.') {
                    set.add(grid[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int m = 0; m < 3; m++) {
                        if (grid[i + k][j + m] != '.' && set.contains(grid[i + k][j + m])) {
                            return false;
                        } else if (grid[i + k][j + m] != '.') {
                            set.add(grid[i + k][j + m]);
                        }
                    }
                }
            }
        }
        return true;
    }

}