import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCounts = new int[30];
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }

        long[] reconstructed = new long[nums.size()];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < bitCounts[i]; j++) {
                reconstructed[j] |= (1L << i);
            }
        }

        long totalSum = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i < k; i++) {
            totalSum = (totalSum + (reconstructed[i] * reconstructed[i]) % mod) % mod;
        }

        return (int) totalSum;
    }
}