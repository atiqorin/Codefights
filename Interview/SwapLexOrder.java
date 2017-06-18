class SwapLexOrder {
    static int[] parent;
    static int[] rank;

    String swapLexOrder(String str, int[][] pairs) {
        rank = new int[str.length()];
        parent = new int[str.length()];

        Arrays.fill(rank, 0);
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] pair : pairs) {
            union(pair[0] - 1, pair[1] - 1);
        }
        char[] arr = str.toCharArray();
        boolean[] processed = new boolean[parent.length];
        for (int i = 0; i < parent.length; i++) {
            if (processed[i]) {
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            processed[i] = true;
            for (int j = i + 1; j < parent.length; j++) {
                if (find(i) == find(j)) {
                    list.add(j);
                    processed[j] = true;
                }
            }
            if (list.size() == 1) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int k : list) {
                sb.append(str.charAt(k));
            }
            char[] cs = sb.toString().toCharArray();
            Arrays.sort(cs);
            Collections.sort(list);
            for (int k = 0; k < cs.length; k++) {
                arr[list.get(k)] = cs[cs.length - 1 - k];
            }
        }
        return new String(arr);
    }

    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}