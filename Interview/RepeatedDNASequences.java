class RepeatedDNASequences {
    String[] repeatedDNASequences(String s) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> resSet = new HashSet<>();
        for (int i = 0; i < s.length() && i + 10 <= s.length(); i++) {
            String substr = s.substring(i, i + 10);
            System.out.println(substr);
            if (set.contains(substr)) {
                resSet.add(substr);
            }
            set.add(substr);
        }
        for (String str : resSet) {
            list.add(str);
        }
        String[] res = list.toArray(new String[0]);
        Arrays.sort(res);
        return res;
    }
}