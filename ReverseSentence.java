class ReverseSentence {
    String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        Stack<String> stack = new Stack<>();
        for (String s : words) {
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        while (!stack.isEmpty()) {
            sb.append(prefix + stack.pop());
            prefix = " ";
        }
        return sb.toString();
    }
}