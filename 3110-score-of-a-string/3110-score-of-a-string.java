class Solution {
    public int scoreOfString(String s) {
       int n = s.length();
       int a=0,b=0,sum=0;
       for(int i=0;i<n-1;i++){
        a = s.charAt(i)-'a';
        b = s.charAt(i+1)-'a';
        sum+=Math.abs(a-b);
       }
        return sum;
    }
}