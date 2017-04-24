class RegularExpressionMatching {
    boolean regularExpressionMatching(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        if (p.length() == 1) {
            if (s.length() < 1) {
                return false;
            }

            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }

            else {
                return regularExpressionMatching(s.substring(1), p.substring(1));
            }
        }

        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            }
            if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            } else {
                return regularExpressionMatching(s.substring(1), p.substring(1));
            }
        } else {
            if (regularExpressionMatching(s, p.substring(2))) {
                return true;
            }

            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (regularExpressionMatching(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}