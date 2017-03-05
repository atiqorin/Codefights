class ContainsDuplicates {
    boolean containsDuplicates(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : a) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}