class ContainsCloseNums {
    boolean containsCloseNums(int[] nums, int k) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nodes.add(new Node(nums[i], i));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.value - n2.value;
            }
        });
        for (int i = 1; i < nums.length; i++) {
            if (nodes.get(i).value == nodes.get(i - 1).value) {
                if (Math.abs(nodes.get(i).index - nodes.get(i - 1).index) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    class Node {
        public int value;
        public int index;

        public Node(int v, int i) {
            value = v;
            index = i;
        }

    }
}