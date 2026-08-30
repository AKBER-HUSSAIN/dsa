class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int mini=0,maxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=min){
                min=nums[i];
                mini=i;
            }
            if(nums[i]>max){
                max=nums[i];
                maxi=i;
            }
        }

        int lefti = Math.min(mini,maxi);
        int righti = Math.max(mini,maxi);

        int fromleft = righti+1;
        int fromright = n-lefti;
        int both = (lefti+1)+(n-righti);

        return Math.min(fromleft,Math.min(fromright,both));

    }
}