class IsCryptSolution {
    boolean isCryptSolution(String[] crypt, char[][] solution) {
        HashMap<Character, Character> map = new HashMap<>();

        for (char[] each : solution) {
            map.put(each[0], each[1]);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : crypt[0].toCharArray()) {
            sb.append(map.get(c));
        }
        String str1 = sb.toString();

        long num1 = Long.parseLong(str1);

        sb = new StringBuilder();
        for (char c : crypt[1].toCharArray()) {
            sb.append(map.get(c));
        }
        String str2 = sb.toString();
        long num2 = Long.parseLong(str2);

        sb = new StringBuilder();
        for (char c : crypt[2].toCharArray()) {
            sb.append(map.get(c));
        }
        String str3 = sb.toString();

        long num3 = Long.parseLong(str3);

        if (num1 + num2 == num3) {
            if (num1 == 0 && num2 == 0 && num3 == 0 && str1.length() == 1 
                    && str2.length() == 1 && str2.length() == 1) {
                return true;
            }
            if (str1.charAt(0) == '0' || str2.charAt(0) == '0' || str3.charAt(0) == '0') {
                return false;
            }
            return true;
        }
        return false;
    }
}