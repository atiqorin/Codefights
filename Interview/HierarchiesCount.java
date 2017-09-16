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
        
        return (n * det(cof, n - 1))%MODULO;
    }
    int det(long[][] mat, int n){
        Fraction[][] _mat = new Fraction[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                _mat[i][j] = new Fraction(mat[i][j], 1L);
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                if(_mat[i-1][i-1].Num == 0){
                    continue;
                }
                Fraction divisor = Divide(_mat[j][i-1],_mat[i-1][i-1]);
                for(int k = 0; k < n; k++){
                    _mat[j][k] = Minus(_mat[j][k], Mult(_mat[i-1][k], divisor));
                }
            }
        }
        Fraction ans = new Fraction(_mat[0][0].Num,_mat[0][0].Den);
        for(int i = 1; i < n; i++){
            ans = Mult(ans, _mat[i][i]);
        }
        return (int)(ans.Num % MODULO);
    }
    Fraction Minus(Fraction a, Fraction b){
        if(a.Num == 0){
            return new Fraction(-b.Num, b.Den);
        }
        if(b.Num == 0){
            return new Fraction(a.Num, a.Den);
        }
        long Den = a.Den / gcd(a.Den, b.Den) * b.Den;
        long Num = a.Num * Den / a.Den - b.Num * Den / b.Den;
        return new Fraction(Num, Den);
    }
    Fraction Mult(Fraction a, Fraction b){
        if(a.Num == 0 || b.Num == 0){
            return new Fraction(0L,1L);
        }
        long _gcd = gcd(a.Num, b.Den);
        long _aNum = a.Num / _gcd;
        long _bDen = b.Den / _gcd;
        
        _gcd = gcd(a.Den, b.Num);
        long _aDen = a.Den / _gcd;
        long _bNum = b.Num / _gcd;
        return new Fraction(_aNum * _bNum, _aDen * _bDen);
    }
    Fraction Divide(Fraction a, Fraction b){
        Fraction _inverseB = new Fraction(b.Den, b.Num);
        return Mult(a, _inverseB);
    }
    long gcd(long a, long b){
        if(a == 0 || b == 0){
            return a + b;
        }
        return gcd(b, a%b);
    }
    class Fraction {
        public long Num;
        public long Den;
        public Fraction(long Num, long Den){
            long _gcd = 1L;
            if(Den != 1){
                _gcd = gcd(Num, Den);
            }
            this.Num = Num/_gcd;
            this.Den = Den/_gcd;
        }
    }
}