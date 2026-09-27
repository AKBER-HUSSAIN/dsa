class Solution {
    public String reverseParentheses(String s) {
        int n = s.length(), open=0, close=0;
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf("(")!=-1){
            open = sb.lastIndexOf("(");
            close = sb.indexOf(")",open);

            String rev = new StringBuilder(sb.substring(open+1,close)).reverse().toString();

            sb.replace(open,close+1,rev);
        }

        return sb.toString();

    }
}