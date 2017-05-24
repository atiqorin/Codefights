class DecodeString {
    String decodeString(String s) {
        char[] sc = s.toCharArray();
        if (s.indexOf('[') == -1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] >= 'a' && sc[i] <= 'z') {
                sb.append(sc[i]);
            }
            if (sc[i] >= '0' && sc[i] <= '9') {
                StringBuilder dsb = new StringBuilder();
                dsb.append(sc[i]);
                for (int k = i + 1; sc[k] >= 0 && sc[k] <= '9'; k++) {
                    dsb.append(sc[k]);
                    i = k;
                }
                int digit = Integer.parseInt("" + dsb.toString());
                int start = i + 2;
                int level = 0;
                for (int k = start; k < sc.length; k++) {
                    if (sc[k] == '[') {
                        level++;
                    } else if (sc[k] == ']') {
                        if (level != 0) {
                            level--;
                        } else {
                            String decoded = decodeString(s.substring(start, k));
                            for (int j = 0; j < digit; j++) {
                                sb.append(decoded);
                            }
                            i = k;
                            break;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}