import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int ans = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;
        int currentMin = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            windowSum += arr[right];
            
            while (windowSum > target) {
                windowSum -= arr[left];
                left++;
            }
            
            if (windowSum == target) {
                int currLen = right - left + 1;
                
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currLen + minLen[left - 1]);
                }
                
                currentMin = Math.min(currentMin, currLen);
            }
            
            minLen[right] = currentMin;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}