class AmendTheSentence {
    String amendTheSentence(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        System.out.println((int) 'a' + " " + (int) 'A');
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < 'a') {
                sb.append(" ");
                sb.append((char) (s.charAt(i) + 32));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString().toLowerCase();
    }
}