// class Solution {
//     public int maxScore(int[] cardPoints, int k) {
//         int n = cardPoints.length;
//         int s=0,ms=0,left=0,right=0;
//         for(int i=n-k;i<n;i++){
//             s+=cardPoints[i];
//         }
//         ms=s;
//         right=n-k;
//         for(int i=0;i<k;i++){
//             s = s+cardPoints[left]-cardPoints[right];
//             ms = Math.max(ms,s);
//             left++;
//             right++;
//         }
//         return ms;
//     }
// }

class Solution {
    static {
        for(int i = 0; i < 500; i++){
            new Solution().maxScore(new int[1], 1);
        }
    }
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        if(k > len) return -1;
        int maxSum = 0;
        int leftSum = 0;
        for(int i = 0; i < k; i++){
            leftSum += cardPoints[i];
        }

        maxSum = Math.max(maxSum, leftSum);
        for(int i = 0; i < k; i++){
            leftSum -= cardPoints[k-i-1];
            leftSum += cardPoints[len-1-i];
            maxSum = Math.max(maxSum, leftSum);
        }
        return maxSum;
    }
}