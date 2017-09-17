class HierarchiesCount {
    static int MODULO;
    int hierarchiesCount(int n, int[][] respectList) {
        if(n == 1){
            return 1;
        }
        MODULO = 1_000_000_007;
        long[][] mat = new long[n][n];
        for(int[] v: respectList){
            mat[v[0]][v[1]] = -1;
            mat[v[1]][v[0]] = -1;
            mat[v[0]][v[0]]++;
            mat[v[1]][v[1]]++;
        }
        long[][] cof = new long[n-1][n-1];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                cof[i-1][j-1] = mat[i][j];
            }
        }
        
        int k = (n * det(cof, n - 1))%MODULO;
        if(k < 0){
            k += MODULO;
            k %= MODULO;
        }
        return k;
    }
    int det(long[][] mat, int n){
        ArrayList<Long> left = new ArrayList<>();
        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                if(mat[j][i-1] == 0 || mat[i-1][i-1] == 0){
                    continue;
                }
                long _lcm = lcm(mat[i-1][i-1], mat[j][i-1]);
                long rowMult = (_lcm / mat[j][i-1])%MODULO;
                long subMult = (_lcm / mat[i-1][i-1])%MODULO;
                left.add((_lcm / mat[j][i-1])%MODULO);
                for(int k = i - 1; k < n; k++){
                    mat[j][k] = (mat[j][k]*rowMult)%MODULO - (mat[i-1][k]*subMult)%MODULO;
                }
            }
        }
        long ans = 1;
        for(int i = 0; i < n; i++){
            ans = (ans * mat[i][i]) % MODULO;
        }
        for(long l: left){
            if(l < 0){
                l += MODULO;
                l %= MODULO;
            }
            ans = (ans * modInverse(l, MODULO)) % MODULO;
        }
        if(ans < 0){
            ans += MODULO;
            ans %= MODULO;
        }
        return (int)ans;
    }
    long modInverse(long a, long m){
        long _m = m;
        long temp;
        long q;
        long x = 0;
        long y = 1;
        while(a > 1){
            temp = m;
            q = a / m;
            m = a % m;
            a = temp;
            temp = x;
            x = y - q * x;
            y = temp;
        }
        if(y < 0){
            y += _m;
        }
        return y;
    }
    long lcm(long a, long b){
        long m = (a / gcd(a, b))* b;
        return m;
    }
    long gcd(long a, long b){
        if(a == 0 || b == 0){
            return a + b;
        }
        return gcd(b, a%b);
    }
     
}