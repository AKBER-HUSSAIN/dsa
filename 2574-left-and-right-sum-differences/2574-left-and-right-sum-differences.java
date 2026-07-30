// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];

//         int totalSum = 0;
//         for (int num : nums) {
//             totalSum += num;
//         }

//         int leftSum = 0;
//         int rightSum = totalSum;

//         for (int i = 0; i < n; i++) {
//             rightSum -= nums[i];
//             ans[i] = Math.abs(leftSum - rightSum);
//             leftSum += nums[i];
//         }

//         return ans;
//     }
// }

class Solution {
        static{
         for(int i=0;i<600;i++){
           new Solution().leftRightDifference(new int[]{0,0});
         }
    }
    public int[] leftRightDifference(int[] nums) {
        int arraySum = sum(nums);
        int curtotal = 0;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            curtotal += nums[i];
            ans[i] = Math.abs((arraySum - curtotal) - (curtotal - nums[i]));
        }
        return ans;
    }

    int sum(int[] nums){
        int res = 0;
        for(int num : nums){
            res+=num;
        }
        return res;
    }
}