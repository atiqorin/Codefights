class HasPathWithGivenSum {
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
    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if (t == null) {
            if (s == 0) {
                return true;
            }
            return false;
        }
        return sum(t, s, 0);
    }

    boolean sum(Tree<Integer> t, int s, int i) {
        if (t != null && (t.left == null || t.right == null) && s == t.value + i) {
            return true;
        } else if (t == null) {
            return false;
        }
        if (sum(t.left, s, t.value + i)) {
            return true;
        } else if (sum(t.right, s, t.value + i)) {
            return true;
        }
        return false;
    }
}