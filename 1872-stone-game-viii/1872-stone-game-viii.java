class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Calculate prefix sums in-place to save memory
        int[] pref = new int[n];
        pref[0] = stones[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + stones[i];
        }
        
        // Base case: Taking all stones leaves pref[n - 1] points
        int maxDiff = pref[n - 1];
        
        // Dynamic programming from right to left (index n - 2 down to 1)
        for (int i = n - 2; i >= 1; i--) {
            maxDiff = Math.max(maxDiff, pref[i] - maxDiff);
        }
        
        return maxDiff;
    }
}