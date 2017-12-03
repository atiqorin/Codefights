class DigitTreeSum {
    //
    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }
    long digitTreeSum(Tree<Integer> t) {
        ArrayList<String> list = new ArrayList<>();
        int[] path = new int[100];
        Arrays.fill(path, -1);
        getPath(t, path, 0, list);
        long ans = 0;
        for (String s : list) {
            ans += Long.parseLong(s);
        }
        return ans;
    }

    void getPath(Tree<Integer> t, int[] path, int len, ArrayList<String> list) {
        if (t == null) {
            return;
        }
        path[len] = t.value;
        len++;
        if (t.left == null && t.right == null) {
            int i = 0;
            String s = "";
            while (i < len) {
                s += path[i];
                i++;
            }
            System.out.println(s);
            list.add(s);
        } else {
            getPath(t.left, path, len, list);
            getPath(t.right, path, len, list);
        }
    }
}