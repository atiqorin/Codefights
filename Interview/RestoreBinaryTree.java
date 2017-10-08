class RestoreBinaryTree {
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
    Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
        return build(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    Tree<Integer> build(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int val = preorder[preStart];
        Tree<Integer> t = new Tree<Integer>(val);
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                k = i;
                break;
            }
        }
        t.left = build(inorder, preorder, inStart, k - 1, preStart + 1, preStart + (k - inStart));
        t.right = build(inorder, preorder, k + 1, inEnd, preStart + (k - inStart) + 1, preEnd);
        return t;
    }
}