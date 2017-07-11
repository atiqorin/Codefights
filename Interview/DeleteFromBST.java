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
    static boolean leftNode;

    Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
        leftNode = false;
        for (int q : queries) {
            t = deleteNode(t, q, null);
        }
        return t;
    }

    Tree<Integer> deleteNode(Tree<Integer> t, int q, Tree<Integer> parent) {
        if (t == null) {
            return null;
        }
        ArrayList<Tree<Integer>> nodes = findNode(t, q, null, false);
        if (nodes == null) {
            return t;
        }
        if (nodes.get(0).left == null) {
            if (nodes.get(1) != null) {
                if (leftNode) {
                    nodes.get(1).left = nodes.get(0).right;
                } else {
                    nodes.get(1).right = nodes.get(0).right;
                }
            } else {
                t = t.right;
                return t;
            }
        } else {
            ArrayList<Tree<Integer>> arr = findMax(nodes.get(0).left, nodes.get(0));
            if (arr.get(1).value != nodes.get(0).value) {
                arr.get(1).right = null;
            } else {
                arr.get(1).left = arr.get(0).left;
            }
            nodes.get(0).value = arr.get(0).value;
        }
        return t;
    }

    ArrayList<Tree<Integer>> findNode(Tree<Integer> t, int q, Tree<Integer> par, boolean side) {
        if (t == null) {
            return null;
        }
        ArrayList<Tree<Integer>> nodes = new ArrayList<>();
        if (t.value == q) {
            nodes.add(t);
            nodes.add(par);
            leftNode = side;
        } else if (t.value < q) {
            nodes = findNode(t.right, q, t, false);
        } else {
            nodes = findNode(t.left, q, t, true);
        }
        return nodes;
    }

    ArrayList<Tree<Integer>> findMax(Tree<Integer> t, Tree<Integer> par) {
        Tree<Integer> p = par;
        while (t.right != null) {
            p = t;
            t = t.right;
        }
        ArrayList<Tree<Integer>> arr = new ArrayList<Tree<Integer>>();
        arr.add(t);
        arr.add(p);
        return arr;
    }
}