class Solution {
    public boolean sumGame(String num) {
        int lefts=0, rights=0, leftq=0, rightq=0;
        int half = num.length()/2;

        for(int i=0;i<half;i++){
            if(num.charAt(i)=='?'){
                leftq++;
            }
            else{
                lefts += num.charAt(i)-'0';
            }
        }
        for(int i=half;i<num.length();i++){
            if(num.charAt(i)=='?'){
                rightq++;
            }
            else{
                rights += num.charAt(i)-'0';
            }
        }

        if ((leftq+rightq)%2 != 0)
            return true;
        
        return 2*(lefts-rights) != 9*(rightq-leftq);
    }
}