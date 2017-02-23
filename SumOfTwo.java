class SumOfTwo {
    boolean sumOfTwo(int[] a, int[] b, int v) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int ai : a) {
            set.add(v - ai);
        }
        for (int bi : b) {
            if (set.contains(bi)) {
                return true;
            }
        }
        return false;
    }
}