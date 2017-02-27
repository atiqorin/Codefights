class IsPowerOfTwo2 {
    boolean isPowerOfTwo2(String n) {
        long num = Long.parseLong(n);
        return (num & (num - 1)) == 0;
    }
}