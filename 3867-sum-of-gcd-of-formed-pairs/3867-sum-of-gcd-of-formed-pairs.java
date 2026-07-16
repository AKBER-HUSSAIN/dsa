// class Solution {

//     public long gcdSum(int[] nums) {
//         int n=nums.length;
//         int[] pg = new int[n];    
//         long num=0;
//         int mx = nums[0];
//         for(int i=0;i<n;i++){
//             mx = Math.max(mx,nums[i]);
//             pg[i] = gcd(nums[i],mx);
//         }
//         Arrays.sort(pg);
//         for(int l=0,r=n-1; l<r; l++,r--){
//             num += gcd(pg[l],pg[r]);
//         }
//         return num;
//     }
//     public static int gcd(int a, int b){
//         if (b==0){
//             return a;
//         }
//         return gcd(b,a%b);
//     }

// }


// optimized Code 

class Solution {
   
    public long gcdSum(int[] arr) {
        int[] prefi = new int[arr.length];
        int mx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
            prefi[i] = gcd(mx, arr[i]);
        }
        Arrays.sort(prefi);
        int i = 0;
        int j = arr.length - 1;
        long sum = 0;
        while (i < j) {
            sum += gcd(prefi[i], prefi[j]);
            i++;
            j--;
        }
        return sum;
    }

     public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

