class TripletSum {
    boolean tripletSum(int x, int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean flag = doubleSum(x - a[i], a, i);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    boolean doubleSum(int x, int[] a, int exclude) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length && i != exclude; i++) {
            if (set.contains(x - a[i])) {
                return true;
            } else {
                set.add(a[i]);
            }
        }
        return false;
    }
}