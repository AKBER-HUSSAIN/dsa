import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000;

        // 1. Precompute proper divisors for every possible substring length
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }

        // 2. Precompute minimum changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                for (int d : divisors[len]) {
                    cost[i][j] = Math.min(cost[i][j], getSemiPalindromeCost(s, i, j, d));
                }
            }
        }

        // 3. DP to partition prefix of length 'end' into 'parts' semi-palindromes
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            // Each part needs at least 2 characters
            for (int end = parts * 2; end <= n; end++) {
                for (int split = (parts - 1) * 2; split <= end - 2; split++) {
                    if (dp[parts - 1][split] != INF) {
                        dp[parts][end] = Math.min(dp[parts][end], dp[parts - 1][split] + cost[split][end - 1]);
                    }
                }
            }
        }

        return dp[k][n];
    }

    // Helper to calculate changes needed for substring s[start..end] with divisor d
    private int getSemiPalindromeCost(String s, int start, int end, int d) {
        int changes = 0;
        for (int offset = 0; offset < d; offset++) {
            int left = start + offset;
            // Find the last index in this modulo group
            int right = end - ((end - start - offset) % d);
            
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    changes++;
                }
                left += d;
                right -= d;
            }
        }
        return changes;
    }
}