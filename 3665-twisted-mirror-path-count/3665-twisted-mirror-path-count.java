class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // go[i][j][0] -> landing cell if we try to move RIGHT from (i, j)
        // go[i][j][1] -> landing cell if we try to move DOWN from (i, j)
        // Stored as encoded integer: r * n + c, or -1 if out of bounds.
        int[][][] go = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Precompute move RIGHT from (i, j)
                go[i][j][0] = getLanding(grid, m, n, i, j, 0);
                // Precompute move DOWN from (i, j)
                go[i][j][1] = getLanding(grid, m, n, i, j, 1);
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                // Try moving right
                int rRight = go[i][j][0];
                if (rRight != -1) {
                    int nx = rRight / n;
                    int ny = rRight % n;
                    dp[nx][ny] = (dp[nx][ny] + dp[i][j]) % MOD;
                }

                // Try moving down
                int rDown = go[i][j][1];
                if (rDown != -1) {
                    int nx = rDown / n;
                    int ny = rDown % n;
                    dp[nx][ny] = (dp[nx][ny] + dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }

    private int getLanding(int[][] grid, int m, int n, int r, int c, int dir) {
        // dir: 0 for trying to go right, 1 for trying to go down
        int currR = r;
        int currC = c;
        int currentDir = dir;

        while (true) {
            int nextR = currR + (currentDir == 1 ? 1 : 0);
            int nextC = currC + (currentDir == 0 ? 1 : 0);

            // Check out of bounds
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) {
                return -1;
            }

            // If it's an empty cell, we successfully land here
            if (grid[nextR][nextC] == 0) {
                return nextR * n + nextC;
            }

            // If it hits a mirror, it reflects:
            // If it entered while moving right (0), it turns down (1)
            // If it entered while moving down (1), it turns right (0)
            currentDir = 1 - currentDir;
            currR = nextR;
            currC = nextC;
        }
    }
}