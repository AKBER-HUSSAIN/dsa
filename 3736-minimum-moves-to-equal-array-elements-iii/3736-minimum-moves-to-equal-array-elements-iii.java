class Solution {
    public int minMoves(int[] nums) {
        int l=nums[0];
        for(int i:nums){
            l = Math.max(l,i);
        }
        int m=0;
        for(int i:nums){
            m+=Math.abs(l-i);
        }
        return m;
    }
}