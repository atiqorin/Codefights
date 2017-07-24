class FindSubstrings {
    String[] findSubstrings(String[] words, String[] parts) {
        TrieNode root = new TrieNode();
        for (String part : parts) {
            insert(root, part);
        }
        ArrayList<String> reslist = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Prefix ans = null;
            ArrayList<Prefix> list = new ArrayList<>();
            for (int k = 0; k < word.length(); k++) {
                ArrayList<Prefix> newList = new ArrayList<>();
                for (int p = 0; p < list.size(); p++) {
                    String cur = list.get(p).prefix + word.charAt(k);
                    TrieNode t = search(root, cur);
                    if (t != null) {
                        int index = list.get(p).start;
                        newList.add(new Prefix(cur, index));
                        if (t.isLeaf) {
                            if (ans == null) {
                                ans = new Prefix(cur, index);
                            } else {
                                if (ans.prefix.length() < cur.length()) {
                                    ans = new Prefix(cur, index);
                                }
                            }
                        }
                    }
                }
                list = newList;
                String cur = "" + word.charAt(k);
                TrieNode t = search(root, cur);
                if (t != null) {
                    list.add(new Prefix(cur, k));
                    if (t.isLeaf) {
                        if (ans == null) {
                            ans = new Prefix(cur, k);
                        } else {
                            if (ans.prefix.length() < cur.length()) {
                                ans = new Prefix(cur, k);
                            }
                        }
                    }
                }
            }
            if (ans != null) {
                word = word.substring(0, ans.start) + "[" + ans.prefix + "]"
                        + word.substring(ans.start + ans.prefix.length());
            }
            reslist.add(word);
        }
        return reslist.toArray(new String[0]);
    }

    class Prefix {
        public String prefix;
        public int start;

        public Prefix(String prefix, int start) {
            this.prefix = prefix;
            this.start = start;
        }
    }

    class TrieNode {
        public char c;
        public boolean isLeaf;
        public HashMap<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(char c) {
            this.c = c;
        }
    }

    public void insert(TrieNode root, String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t = new TrieNode();
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;

            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    public TrieNode search(TrieNode root, String word) {
        HashMap<Character, TrieNode> children = root.children;

        TrieNode t = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }
}