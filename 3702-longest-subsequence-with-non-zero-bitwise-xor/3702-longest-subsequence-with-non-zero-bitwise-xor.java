class Solution {
    public int longestSubsequence(int[] nums) {

        int xor = 0;
        int zeroCount = 0;
        int n = nums.length;

        for (int x : nums) {
            xor ^= x;

            if (x == 0) {
                zeroCount++;
            }
        }

        // Case 1
        if (xor != 0) {
            return n;
        }

        // Case 2 and 3
        if (zeroCount == n) {
            return 0;
        }

        return n - 1;
    }
}
