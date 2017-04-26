class PressingButtons {
    String[] pressingButtons(String buttons) {
        if (buttons.length() == 0) {
            return new String[0];
        }
        return solve(buttons, "", 0);
    }

    String[] solve(String btns, String pref, int i) {
        if (i == btns.length()) {
            return new String[] { pref };
        }
        String[] cur = buttonValues(btns.charAt(i));
        String[] candidate = new String[cur.length];
        for (int j = 0; j < cur.length; j++) {
            candidate[j] = pref + cur[j];
        }
        ArrayList<String> list = new ArrayList<>();
        for (String s : candidate) {
            for (String res : solve(btns, s, i + 1)) {
                list.add(res);
            }
        }
        return list.toArray(new String[0]);
    }

    String[] buttonValues(char c) {
        switch (c) {
        case '2':
            return new String[] { "a", "b", "c" };
        case '3':
            return new String[] { "d", "e", "f" };
        case '4':
            return new String[] { "g", "h", "i" };
        case '5':
            return new String[] { "j", "k", "l" };
        case '6':
            return new String[] { "m", "n", "o" };
        case '7':
            return new String[] { "p", "q", "r", "s" };
        case '8':
            return new String[] { "t", "u", "v" };
        case '9':
            return new String[] { "w", "x", "y", "z" };
        default:
            return new String[0];
        }
    }
}