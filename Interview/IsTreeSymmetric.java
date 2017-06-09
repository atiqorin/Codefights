class IsTreeSymmetric {
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
    boolean isTreeSymmetric(Tree<Integer> t) {
        if (t == null) {
            return true;
        }
        return inOrder(t.left).equals(outOrder(t.right));
    }

    String inOrder(Tree<Integer> t) {
        if (t == null) {
            return "";
        }
        //StringBuilder sb = new StringBuilder();
        String left = inOrder(t.left);
        String right = inOrder(t.right);
        return left + t.value + right;
    }

    String outOrder(Tree<Integer> t) {
        if (t == null) {
            return "";
        }
        //StringBuilder sb = new StringBuilder();
        String left = outOrder(t.left);
        String right = outOrder(t.right);
        return right + t.value + left;
    }
}