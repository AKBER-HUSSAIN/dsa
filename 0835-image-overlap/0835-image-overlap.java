class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> p1 = new ArrayList<>();
        List<int[]> p2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) p1.add(new int[]{i, j});
                if (img2[i][j] == 1) p2.add(new int[]{i, j});
            }
        }
        
        Map<String, Integer> count = new HashMap<>();
        int maxOverlap = 0;
        
        for (int[] a : p1) {
            for (int[] b : p2) {
                int dx = b[0] - a[0];
                int dy = b[1] - a[1];
                String key = dx + "," + dy;
                int current = count.getOrDefault(key, 0) + 1;
                count.put(key, current);
                maxOverlap = Math.max(maxOverlap, current);
            }
        }
        
        return maxOverlap;
    }
}