class Solution {
    public boolean checkDivisibility(int n) {
        int s=0,m=1,n1=n,rem=0;
        while(n!=0){
            rem = n%10;
            s+=rem;
            m*=rem;
            n=n/10;
        }
        return (n1%(s+m)==0)?true:false;
    }
}