class Bomber {
    int bomber(char[][] field) {
        int ans = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == '0') {
                    int num = 0;
                    int t = j;
                    while (t >= 0 && field[i][t] != 'W') {
                        if (field[i][t] == 'E') {
                            num++;
                        }
                        t--;
                    }
                    t = j;
                    while (t < field[0].length && field[i][t] != 'W') {
                        if (field[i][t] == 'E') {
                            num++;
                        }
                        t++;
                    }
                    t = i;
                    while (t >= 0 && field[t][j] != 'W') {
                        if (field[t][j] == 'E') {
                            num++;
                        }
                        t--;
                    }
                    t = i;
                    while (t < field.length && field[t][j] != 'W') {
                        if (field[t][j] == 'E') {
                            num++;
                        }
                        t++;
                    }
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }
}