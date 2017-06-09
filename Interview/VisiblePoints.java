class VisiblePoints {
    int visiblePoints(int[][] points) {
        double[] angles = new double[points.length];
        for(int i = 0; i < points.length; i++){
            angles[i] = Math.toDegrees(Math.atan2(points[i][0], points[i][1]));
            if(angles[i] < 0){
                angles[i] += 360.0;
            }
        }
        Arrays.sort(angles);
        
        int max = 1;
        for(int i = 0; i < angles.length; i++){
            int l = i + 1;
            int h = angles.length - 1;
            while(l <= h){
                int j = (l + h) / 2;
                if(angles[j] <= 45.0 + angles[i]){
                    max = Math.max(max, j - i + 1);
                    l = j + 1;
                } else {
                    h = j - 1;
                }
            }
        }
        return max;
    }
}