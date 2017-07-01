class KthLargestInBST {
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
    // 
    static int i;
    static int ans = 0;
    static boolean found;

    int kthLargestInBST(Tree<Integer> t, int k) {
        i = 1;
        ans = 0;
        found = false;
        solve(t, k);
        return ans;
    }

    void solve(Tree<Integer> t, int k) {

        if (t == null) {
            return;
        }

        if (found) {
            return;
        }

        solve(t.left, k);
        if (k == i) {
            ans = t.value;
            found = true;
        }
        i++;
        solve(t.right, k);
    }
}