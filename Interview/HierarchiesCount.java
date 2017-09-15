class HierarchiesCount {
    static int MODULO;
    int hierarchiesCount(int n, int[][] respectList) {
        if(n == 1){
            return 1;
        }
        MODULO = 1000000007;
        int[][] mat = new int[n][n];
        for(int[] v: respectList){
            mat[v[0]][v[1]] = -1;
            mat[v[1]][v[0]] = -1;
            mat[v[0]][v[0]]++;
            mat[v[1]][v[1]]++;
        }
        int[][] cof = new int[n-1][n-1];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                cof[i-1][j-1] = mat[i][j];
            }
        }
        
        return (n * det(cof, n - 1))%MODULO;
    }
    int det(int[][] mat, int n){
        int res = 0;
        if(n == 1){
            return mat[0][0];
        } else if(n == 2){
            return (mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0]) % MODULO;
        } else {
            res = 0;
            int[][] m;
            int sign = 1;
            for(int i = 0; i < n; i++){
                m =  generateCofactor(mat, n, i);
                res += (sign * mat[0][i] * det(m, n - 1)) % MODULO;
                res %= MODULO;
                sign = -sign;
            }
        }
        return res;
    }
    int[][] generateCofactor(int[][] mat, int n, int i){
        int[][] m = new int[n-1][n-1];
        for(int matRow = 1; matRow < n; matRow++){
            int mCol = 0;
            for(int matCol = 0; matCol < n; matCol++){
                if(matCol == i){
                    continue;
                }
                m[matRow-1][mCol] = mat[matRow][matCol];
                mCol++;
            }
        }
        return m;
    }
}