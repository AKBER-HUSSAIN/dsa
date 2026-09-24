class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int si=0;
        for(int i=0;i<n;i++){
            int sod = sumofdigit(nums[i]);
            if(sod==i){
                return i;
            }
        }
        return -1;
    }
    public static int sumofdigit(int n){
        int val=0;
        int rem=0;
        while(n>0){
            rem = n%10;
            val+=rem;
            n=n/10;
        }
        return val;
    } 
}