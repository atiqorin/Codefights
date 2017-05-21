class FirstNotRepeatingCharacter {
    char firstNotRepeatingCharacter(String s) {
        char[] sc = s.toCharArray();
        Count[] count = new Count[26];
        for (int i = 0; i < 26; i++) {
            count[i] = new Count();
        }
        for (int i = 0; i < sc.length; i++) {
            count[(int) sc[i] - (int) 'a'].count++;
            count[(int) sc[i] - (int) 'a'].index = i;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i].count == 1) {
                min = Math.min(min, count[i].index);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return '_';
        }
        return sc[min];
    }

    class Count {
        public int count = 0;
        public int index = -1;
    }
}