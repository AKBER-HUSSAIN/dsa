class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min = nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
        return gcd(min,max);
    }
    public static int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}