class WordLadder {
    int wordLadder(String beginWord, String endWord, String[] wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        HashSet<String> found = new HashSet<>();
        List<String> q = new ArrayList<>();
        q.add(beginWord);
        int res = 1;
        while (q.size() != 0) {
            List<String> toList = new ArrayList<>();
            for (String s : q) {
                if (s.equals(endWord)) {
                    return res;
                }
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char cur = arr[i];
                    for (char c = 'a'; c < 'z'; c++) {
                        if (c == cur) {
                            continue;
                        }
                        arr[i] = c;
                        String str = new String(arr);
                        if (set.contains(str) && !found.contains(str)) {
                            toList.add(str);
                            found.add(str);
                        }
                    }
                    arr[i] = cur;
                }
            }
            q = toList;
            res++;
        }
        return 0;
    }
}