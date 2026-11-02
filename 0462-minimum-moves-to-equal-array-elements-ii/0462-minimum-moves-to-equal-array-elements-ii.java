import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int m=0;
        int median = nums[nums.length/2];

        for(int i:nums){
            m+=Math.abs(median-i);
        }

        return m;
    }
}