class LongestPath {
    int longestPath(String fileSystem) {
        if(fileSystem.indexOf('.') < 0){
            return 0;
        }
        int max = 0;
        String[] arr = fileSystem.split("\f");
        Node root = new Node("");
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(-1, root);
        
        for(String s: arr){
            int curLevel = getLevel(s);
            Node cur = new Node(s, map.get(curLevel - 1));
            map.put(curLevel, cur);
            if(s.indexOf('.') >= 0){
                max = Math.max(max, calcLength(cur));
            }
        }
        
        return max;
    }
    int getLevel(String s) {
        int r = 0;
        while(s.indexOf("\t") >= 0){
            r++;
            s = s.substring(1);
        }
        return r;
    }
    int calcLength(Node n) {
        int r = 0;
        String s = n.value;
        while(s.indexOf("\t") >= 0){
            s = s.substring(1);
        }
        r += s.length();
        if(r==0){
            return 0;
        }
        while(n.parent != null){
            r++;
            n = n.parent;
            s = n.value;
            while(s.indexOf("\t") >= 0){
                s = s.substring(1);
            }
            r += s.length();
        }
        return r - 1;
    }
    class Node {
        public Node parent;
        public String value;
        public Node(String value){
            this.value = value;
            this.parent = null;
        }
        public Node(String value, Node parent){
            this.value = value;
            this.parent = parent;
        }
    }
}