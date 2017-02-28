class TextJustification {
    String[] textJustification(String[] words, int L) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        while (start < words.length) {
            list.clear();
            end = start;
            int prefSpc = 0;
            cur = 0;
            while (end < words.length && cur + prefSpc + words[end].length() <= L) {
                list.add(words[end]);
                cur += prefSpc + words[end].length();
                prefSpc = 1;
                end++;
            }
            start = end;
            sb = new StringBuilder();
            if (list.size() == 1) {
                sb.append(list.get(0));
                int rem = L - list.get(0).length();
                while (rem > 0) {
                    sb.append(" ");
                    rem--;
                }
            } else if (start == words.length) {
                String pref = "";
                for (String s : list) {
                    sb.append(pref + s);
                    pref = " ";
                }
                int rem = L - sb.length();
                while (rem > 0) {
                    sb.append(" ");
                    rem--;
                }
            } else {
                int count = 0;
                for (String s : list) {
                    count += s.length();
                }
                int rem = L - count;
                int spcCnt = list.size() - 1;
                int minSpcCnt = rem / spcCnt;
                System.out.println("@" + minSpcCnt);
                String minSpc = "";
                while (minSpcCnt > 0) {
                    minSpc += " ";
                    minSpcCnt--;
                }
                int rest = rem % spcCnt;
                String pref = "";
                for (String s : list) {
                    sb.append(pref + s);
                    if (rest > 0) {
                        pref = minSpc + " ";
                        rest--;

                    } else {
                        pref = minSpc;
                        System.out.print("1" + minSpc);
                    }
                }
            }
            res.add(sb.toString());
        }
        return res.toArray(new String[0]);
    }

}