class LargestValuesInTreeRows {
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
    int[] largestValuesInTreeRows(Tree<Integer> t) {
        Queue<Tree<Integer>> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.offer(t);
        q.offer(null);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        while (!q.isEmpty()) {
            Tree<Integer> node = q.poll();
            if (node == null) {
                if (pq.size() > 0) {
                    list.add(pq.poll());
                }
                pq.clear();
                q.offer(null);
                if (q.peek() == null) {
                    break;
                } else {
                    continue;
                }
            } else {
                pq.add(node.value);
            }
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