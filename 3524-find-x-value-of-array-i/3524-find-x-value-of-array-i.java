class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] nextDp = new long[k];
            int mod = num % k;
            
            nextDp[mod]++;
            
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    nextDp[(r * mod) % k] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                ans[r] += nextDp[r];
            }

            dp = nextDp;
        }

        return ans;
    }
}