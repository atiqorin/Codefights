class MinimumOnStack {
    public static class MinStack {
        public Stack<Integer> stack;
        public Stack<Integer> min;

        public MinStack() {
            stack = new Stack<Integer>();
            min = new Stack<Integer>();
        }
    }

    int[] minimumOnStack(String[] operations) {
        int output;
        MinStack stack = new MinStack();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            output = execute(operations[i], stack);
            if (operations[i].equals("min")) {
                list.add(output);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    int execute(String cmd, MinStack stack) {
        if (cmd.equals("min")) {
            return stack.min.peek();
        } else if (cmd.equals("pop")) {
            int ret = stack.stack.pop();
            if (stack.min.peek() == ret) {
                stack.min.pop();
            }
            return ret;
        } else {
            String[] split = cmd.split(" ");
            int num = Integer.parseInt(split[1]);
            if (stack.min.size() == 0 || stack.min.peek() > num) {
                stack.min.add(num);
            }
            return stack.stack.push(num);
        }
    }
}