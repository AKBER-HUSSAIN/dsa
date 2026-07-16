class Solution {

    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] pg = new int[n];    
        long num=0;
        int mx = nums[0];
        for(int i=0;i<n;i++){
            mx = Math.max(mx,nums[i]);
            pg[i] = gcd(nums[i],mx);
        }
        Arrays.sort(pg);
        for(int l=0,r=n-1; l<r; l++,r--){
            num += gcd(pg[l],pg[r]);
        }
        return num;
    }
    public static int gcd(int a, int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }

}