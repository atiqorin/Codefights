class RotateImage {
    int[][] rotateImage(int[][] a) {
        if (a.length == 1) {
            return a;
        }
        int layer = 0;
        int maxLayer = -1;
        int len = a.length;
        while (len > 0) {
            maxLayer++;
            len -= 2;
        }
        while (layer <= maxLayer) {
            for (int i = layer; i < a.length - layer - 1; i++) {
                int end = a.length - layer - 1;
                int temp = a[layer][i];
                int offset = i - layer;
                a[layer][i] = a[end - offset][layer];
                a[end - offset][layer] = a[end][end - offset];
                a[end][end - offset] = a[i][end];
                a[i][end] = temp;
            }
            layer++;
        }
        return a;
    }
}