class Solution {
    public int reverseDegree(String s) {
       int n =s.length();
       int sum=0,pos=0;
       for(int i=1;i<=n;i++){
            pos='z'-s.charAt(i-1)+1;
            sum += pos*i;
       } 
       return sum;
    }
}