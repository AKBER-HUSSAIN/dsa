import java.util.*;
class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        long score = 0;
        for(int i=0;i<n;i++){
            sq[i] = (long) nums[i]*nums[i];
        }
        Arrays.sort(sq);
        int mid=n/2;
        for(int i=0;i<mid;i++){
            score -= sq[i];
        }
        for(int j=mid;j<n;j++){
            score+=sq[j];
        }
        return score;
    }
}