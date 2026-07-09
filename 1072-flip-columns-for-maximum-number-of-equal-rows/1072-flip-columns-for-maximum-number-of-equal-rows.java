class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (int[] row : matrix) {
            StringBuilder key = new StringBuilder();

            for (int num : row) {
                if (row[0] == 0) {
                    key.append(num);
                } else {
                    key.append(num ^ 1);
                }
            }

            int count = map.getOrDefault(key.toString(), 0) + 1;
            map.put(key.toString(), count);
            ans = Math.max(ans, count);
        }

        return ans;
    }
}