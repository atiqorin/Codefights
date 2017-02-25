class ReverseInteger {
    int reverseInteger(int x) {
        boolean isNegetive = x < 0;
        if (isNegetive) {
            x *= -1;
        }
        int res = 0;
        int divisor = 1;
        int digit = 0;
        int temp = x;
        int mult = 1;
        while (temp > 0) {
            divisor *= 10;
            temp /= 10;
        }
        divisor /= 10;
        while (divisor > 0) {
            digit = x / divisor;
            x %= divisor;
            divisor /= 10;
            res += digit * mult;
            mult *= 10;
        }
        if (isNegetive) {
            res *= -1;
        }
        return res;
    }
}