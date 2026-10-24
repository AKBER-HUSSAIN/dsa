class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        int i=0,j=2*n-1;
        while(i<n){
            ans[i]=nums[i];
            ans[j]=nums[i];
            i++;
            j--;
        }
        return ans;
    }
}