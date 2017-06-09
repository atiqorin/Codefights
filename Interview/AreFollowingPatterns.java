class AreFollowingPatterns {
    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        int[] s = new int[strings.length];
        int[] p = new int[patterns.length];
        HashMap<String, Integer> sMap = new HashMap<>();
        HashMap<String, Integer> pMap = new HashMap<>();
        int c = 0;
        for (int i = 0; i < strings.length; i++) {
            if (sMap.containsKey(strings[i])) {
                s[i] = sMap.get(strings[i]);
            } else {
                sMap.put(strings[i], c);
                s[i] = c;
                c++;
            }
        }
        c = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (pMap.containsKey(patterns[i])) {
                p[i] = pMap.get(patterns[i]);
            } else {
                pMap.put(patterns[i], c);
                p[i] = c;
                c++;
            }
        }

        for (int i = 0; i < strings.length; i++) {
            if (s[i] != p[i]) {
                return false;
            }
        }
        return true;
    }
}