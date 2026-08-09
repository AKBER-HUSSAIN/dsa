class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        // Suffix sum
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int M, int[] piles) {
        if (i >= n) {
            return 0;
        }

        // Can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }

        if (dp[i][M] != -1) {
            return dp[i][M];
        }

        int maxStones = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = solve(
                i + X,
                Math.max(M, X),
                piles
            );

            int currentPlayer = suffix[i] - opponent;

            maxStones = Math.max(maxStones, currentPlayer);
        }

        return dp[i][M] = maxStones;
    }
}