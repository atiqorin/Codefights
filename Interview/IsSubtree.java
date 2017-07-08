class IsSubtree {
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
    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        String tree1 = preorder(t1);
        String tree2 = preorder(t2);
        return tree1.indexOf(tree2) >= 0;
    }

    public String preorder(Tree<Integer> t) {
        if (t == null) {
            return "null";
        }
        return "@" + t.value + " " + preorder(t.left) + " " + preorder(t.right);
    }
}