class StringReformatting {
    String stringReformatting(String s, int k) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            if (c != '-') {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (!stack.isEmpty()) {
            if (cur == k) {
                cur = 0;
                sb.append('-');
            } else {
                sb.append(stack.pop());
                cur++;
            }
        }
        return sb.reverse().toString();
    }

}