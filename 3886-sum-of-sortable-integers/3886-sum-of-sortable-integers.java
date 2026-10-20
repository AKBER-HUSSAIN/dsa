class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);
        
        int totalSum = 0;
        
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            
            boolean possible = true;
            for (int i = 0; i < n; i += k) {
                if (!isValid(nums, sorted, i, k)) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                totalSum += k;
            }
        }
        
        return totalSum;
    }
    
    private boolean isValid(int[] nums, int[] sorted, int start, int k) {
        for (int shift = 0; shift < k; shift++) {
            boolean match = true;
            for (int i = 0; i < k; i++) {
                if (nums[start + i] != sorted[start + (i + shift) % k]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}