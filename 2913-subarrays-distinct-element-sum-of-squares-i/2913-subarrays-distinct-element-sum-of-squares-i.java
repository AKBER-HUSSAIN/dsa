class Solution {
    public int sumCounts(List<Integer> nums) {
        int totalSum = 0;
        int n = nums.size();
        
        // Generate all possible subarrays
        for (int i = 0; i < n; i++) {
            HashSet<Integer> distinctSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                // Add elements of the current subarray
                distinctSet.add(nums.get(j));
                
                // Square the count of distinct elements and add to totalSum
                int distinctCount = distinctSet.size();
                totalSum += distinctCount * distinctCount;
            }
        }
        
        return totalSum;
    }
}