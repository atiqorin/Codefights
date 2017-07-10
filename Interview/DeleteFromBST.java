class DeleteFromBST {
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
    Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
        for (int q : queries) {
            t = deleteNode(t, q);
        }
        return t;
    }

    Tree<Integer> deleteNode(Tree<Integer> t, int q) {
        if (t == null) {
            return null;
        }
        if (q < t.value) {
            t.left = deleteNode(t.left, q);
        } else if (q > t.value) {
            t.right = deleteNode(t.right, q);
        } else {
            if (t.left == null) {
                return t.right;
            } else if (t.right == null) {
                return t.left;
            }
            t.value = findMax(t.left).value;
            t.left = deleteNode(t.left, t.value);
        }
        return t;
    }

    Tree<Integer> findMax(Tree<Integer> t) {
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }
}