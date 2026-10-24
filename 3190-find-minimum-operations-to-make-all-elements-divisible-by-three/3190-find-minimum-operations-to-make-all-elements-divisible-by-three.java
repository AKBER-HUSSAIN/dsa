class Solution {
    public int minimumOperations(int[] nums) {
        int op=0;
        for(int n:nums){
            if(n%3!=0){
                op++;
            }
        }
        return op;
    }
}