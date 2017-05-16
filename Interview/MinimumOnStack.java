class MinimumOnStack {
    public class MinStack {
        public Stack<Integer> stack;
        public PriorityQueue<Integer> pq;

        public MinStack() {
            stack = new Stack<Integer>();
            pq = new PriorityQueue<>();
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
            return stack.pq.peek();
        } else if (cmd.equals("pop")) {
            int ret = stack.stack.pop();
            if (stack.pq.peek() == ret) {
                stack.pq.poll();
            } else {
                Stack<Integer> temp = new Stack<>();
                while (stack.pq.peek() != ret) {
                    temp.add(stack.pq.poll());
                }
                stack.pq.poll();
                while (!temp.isEmpty()) {
                    stack.pq.add(temp.pop());
                }
            }
            return ret;
        } else {
            String[] split = cmd.split(" ");
            int num = Integer.parseInt(split[1]);
            stack.pq.add(num);
            return stack.stack.push(num);
        }
    }
}