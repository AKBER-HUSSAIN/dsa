class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        memo = new Boolean[m][n][(m + n) / 2 + 1];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int open) {
        open += (grid[r][c] == '(' ? 1 : -1);

        if (open < 0) {
            return false;
        }

        int m = grid.length;
        int n = grid[0].length;

        if (open > (m + n) / 2) {
            return false;
        }

        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }

        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }

        boolean result = false;
        if (r + 1 < m) {
            result = dfs(grid, r + 1, c, open);
        }
        if (!result && c + 1 < n) {
            result = dfs(grid, r, c + 1, open);
        }

        return memo[r][c][open] = result;
    }
}