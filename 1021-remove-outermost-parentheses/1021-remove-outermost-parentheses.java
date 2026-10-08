class Solution {
    public String removeOuterParentheses(String s) {
        String res="";
        int open=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                if(open>0){
                    res+="(";
                }
                open++;
            }
            else{
                open--;
                if(open>0){
                    res+=")";
                }
            }
        }
        return res;
    }
}