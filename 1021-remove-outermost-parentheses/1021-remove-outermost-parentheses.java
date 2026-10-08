class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res=new StringBuilder();
        int open=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                if(open>0){
                    res.append("(");
                }
                open++;
            }
            else{
                open--;
                if(open>0){
                    res.append(")");
                }
            }
        }
        return res.toString();
    }
}