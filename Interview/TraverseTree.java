class TraverseTree {
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
    int[] traverseTree(Tree<Integer> t) {
        Queue<Tree<Integer>> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.offer(t);
        while (!q.isEmpty()) {
            Tree<Integer> node = q.poll();
            if (node == null) {
                break;
            }
            list.add(node.value);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}