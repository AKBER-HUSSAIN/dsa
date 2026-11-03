class Solution {
    public int minMoves(int[] nums) {
        int l=nums[0],s=0;
        for(int i:nums){
            l = Math.max(l,i);
            s+=i;
        }
        return nums.length*l-s;
    }
}