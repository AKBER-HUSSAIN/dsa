class Solution {
    public int minAddToMakeValid(String s) {
        // int n = s.length();
        // Stack<Character> st = new Stack<>();
        // for(int i=0;i<n;i++){
        //     char c = s.charAt(i);
        //     if(c=='('){
        //         st.push(c);
        //     }
        //     else{
        //         if(st.empty()){
        //             break;
        //         }
        //         if(st.peek()=='('){
        //             st.pop();
        //         }
        //     }
        // }
        // return st.size();
        int n = s.length();
        int open=0,close=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }
                else{
                    close++;
                }
            }
        }
        return open+close;
    }
}