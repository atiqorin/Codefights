class GroupingDishes {
    String[][] groupingDishes(String[][] dishes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < dishes.length; i++) {
            for (int j = 1; j < dishes[i].length; j++) {
                if (map.get(dishes[i][j]) == null) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(dishes[i][0]);
                    map.put(dishes[i][j], list);
                } else {
                    ArrayList<String> list = map.get(dishes[i][j]);
                    list.add(dishes[i][0]);
                    map.put(dishes[i][j], list);
                }
            }
        }
        String[] keys = new String[map.size()];
        int m = 0;
        for (String k : map.keySet()) {
            keys[m] = k;
            m++;
        }
        Arrays.sort(keys);
        ArrayList<ArrayList<String>> ansList = new ArrayList<>();
        for (int i = 0; i < keys.length; i++) {
            ArrayList<String> list = map.get(keys[i]);
            Collections.sort(list);
            ArrayList<String> dish = new ArrayList<>();
            dish.add(keys[i]);
            for (String d : list) {
                dish.add(d);
            }
            if (dish.size() > 2) {
                ansList.add(dish);
            }
        }
        String[][] ans = new String[ansList.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ansList.get(i).toArray(new String[0]);
        }
        return ans;
    }
}