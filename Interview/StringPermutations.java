class StringPermutations {
    static ArrayList<String> list;
    String[] stringPermutations(String s) {
        list = new ArrayList<>();
        char[] arr = s.toCharArray();
        boolean[] used = new boolean[arr.length];
        perm(0, arr, used, "");
        HashSet<String> set = new HashSet<>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        String[] res = list.toArray(new String[0]);
        Arrays.sort(res);
        return res;
    }

    void perm(int level, char[] arr, boolean[] used, String permuted) {
        if (permuted.length() == arr.length) {
            list.add(permuted);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm(level + 1, arr, used, permuted + arr[i]);
                    used[i] = false;
                }
            }
        }
    }
}