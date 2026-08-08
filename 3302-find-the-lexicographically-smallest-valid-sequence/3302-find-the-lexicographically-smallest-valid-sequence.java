class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[n + 1];
        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        int idx = 0;
        boolean changed = false;
        j = 0;

        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[idx++] = i;
                j++;
            } else if (!changed && dp[i + 1] >= m - j - 1) {
                ans[idx++] = i;
                j++;
                changed = true;
            }
        }

        return j == m ? ans : new int[0];
    }
}