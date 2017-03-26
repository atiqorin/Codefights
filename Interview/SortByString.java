class SortByString {
    String sortByString(String s, String t) {
        char[] order = t.toCharArray();
        char[] sort = s.toCharArray();
        int head = 0;
        for (char tc : order) {
            for (int i = head; i < sort.length; i++) {
                if (tc == sort[i]) {
                    char temp = sort[head];
                    sort[head] = sort[i];
                    sort[i] = temp;
                    head++;
                }
            }
        }
        return new String(sort);
    }
}