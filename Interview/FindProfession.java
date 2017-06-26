class FindProfession {
    static ArrayList<Boolean> path; //False left, True right

    String findProfession(int level, int pos) {
        path = new ArrayList<>();
        int leafs = 1 << (level - 1);
        if (pos > leafs) {
            return findProfession(level + 1, pos - leafs);
        }
        int absPos = (1 << (level - 1)) + pos - 1;

        while (absPos > 0) {
            int div = absPos / 2;
            if (div * 2 == absPos) {
                path.add(false);
            } else {
                path.add(true);
            }
            absPos = absPos / 2;
        }
        Collections.reverse(path);
        boolean res = false;
        for (boolean r : path) {
            if (res) {
                if (r) {
                    res = false;
                } else {
                    res = true;
                }
            } else {
                if (r) {
                    res = true;
                } else {
                    res = false;
                }
            }
        }
        String ans = (!res) ? "Doctor" : "Engineer";
        return ans;
    }
}