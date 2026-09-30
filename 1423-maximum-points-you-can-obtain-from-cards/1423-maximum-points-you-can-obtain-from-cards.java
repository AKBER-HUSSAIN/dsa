class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int s=0,ms=0,left=0,right=0;
        for(int i=n-k;i<n;i++){
            s+=cardPoints[i];
        }
        ms=s;
        right=n-k;
        for(int i=0;i<k;i++){
            s = s+cardPoints[left]-cardPoints[right];
            ms = Math.max(ms,s);
            left++;
            right++;
        }
        return ms;
    }
}