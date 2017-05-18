class MinSubstringWithAllChars {
    String minSubstringWithAllChars(String s, String t) {
        if (t.length() == 0 || s.length() == 0) {
            return "";
        }
        int start = -1;
        int end = -1;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        char[] sA = s.toCharArray();
        char[] tA = t.toCharArray();

        boolean[] tb = new boolean[26];
        boolean[] found = new boolean[26];
        for (char tc : tA) {
            tb[(int) tc - (int) 'a'] = true;
        }
        int count = 0;
        int ret = 0;
        int retStart = -1;
        int retEnd = -1;
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < sA.length; i++) {
            int si = (int) sA[i] - (int) 'a';
            if (tb[si]) {
                last[si] = i;
                q.offer(i);
                if (count != t.length() && !found[si]) {
                    found[si] = true;
                    count++;
                }
                if (start == -1) {
                    start = i;
                    retStart = start;
                }
                if (count == t.length()) {
                    if (end == -1) {
                        end = i;
                        retEnd = end;
                        ret = end - start + 1;
                        while (true) {
                            if (last[(int) sA[start] - (int) 'a'] == start) {
                                ret = end - start + 1;
                                if (retEnd - retStart + 1 > ret) {
                                    retEnd = end;
                                    retStart = start;
                                }
                                break;
                            } else {
                                q.poll();
                                start = q.peek();
                                System.out.println(start);
                                ret = end - start + 1;
                                if (retEnd - retStart + 1 > ret) {
                                    retEnd = end;
                                    retStart = start;
                                }
                            }
                        }
                    } else {
                        if (sA[start] == sA[i]) {
                            q.poll();
                            start = q.peek();
                            System.out.println(start + " " + i);
                            end = i;
                            ret = end - start + 1;
                            if (retEnd - retStart + 1 > ret) {
                                retEnd = end;
                                retStart = start;
                            }
                            while (true) {
                                if (last[(int) sA[start] - (int) 'a'] == start) {
                                    ret = end - start + 1;
                                    if (retEnd - retStart + 1 > ret) {
                                        retEnd = end;
                                        retStart = start;
                                    }
                                    break;
                                } else {
                                    q.poll();
                                    start = q.peek();
                                    System.out.println(start);
                                    ret = end - start + 1;
                                    if (retEnd - retStart + 1 > ret) {
                                        retEnd = end;
                                        retStart = start;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return s.substring(retStart, retEnd + 1);
    }
}