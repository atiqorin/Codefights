class SortedSquaredArray {
    int[] sortedSquaredArray(int[] array) {
        int[] ans = new int[array.length];
        int s = 0;
        int e = array.length - 1;
        Stack<Integer> stack = new Stack<Integer>();
        while (e >= s) {
            if (Math.abs(array[s]) > Math.abs(array[e])) {
                stack.push(array[s] * array[s]);
                s++;
            } else {
                stack.push(array[e] * array[e]);
                e--;
            }
        }
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }
}