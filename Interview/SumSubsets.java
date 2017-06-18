class SumSubsets {
    ArrayList<ArrayList<Integer>> res;

    int[][] sumSubsets(int[] arr, int num) {
        res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        subset(list, new ArrayList<Integer>(), num);
        HashSet<String> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> r : res) {
            StringBuilder sb = new StringBuilder();
            for (int i : r) {
                sb.append("" + i);
            }
            String s = sb.toString();
            if (!set.contains(s)) {
                set.add(s);
                result.add(r);
            }
        }
        res = result;
        Collections.reverse(res);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    void subset(ArrayList<Integer> list, ArrayList<Integer> cur, int num) {
        int sum = 0;
        for (int i : cur) {
            sum += i;
        }
        if (sum == num) {
            res.add(cur);
            return;
        } else if (sum > num) {
            return;
        }
        if (list.size() == 0) {
            return;
        }
        int i = list.get(0);

        ArrayList<Integer> recList = new ArrayList<>();
        ArrayList<Integer> recCur = new ArrayList<>();

        recCur.addAll(cur);

        recList.addAll(list);

        recList.remove(0);
        
        subset(recList, recCur, num);
        recCur.add(i);
        subset(recList, recCur, num);
    }
}