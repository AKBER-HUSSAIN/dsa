// class Solution {
//     public int minMoves(int[] nums) {
//         int l=nums[0],s=0;
//         for(int i:nums){
//             l = Math.max(l,i);
//             s+=i;
//         }
//         return nums.length*l-s;
//     }
// }

class Solution {
    public int minMoves(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }

        return nums.length * max - sum;
    }
}