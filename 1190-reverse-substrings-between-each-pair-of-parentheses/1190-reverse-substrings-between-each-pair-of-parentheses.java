// class Solution {
//     public String reverseParentheses(String s) {
//         int n = s.length(), open=0, close=0;
//         StringBuilder sb = new StringBuilder(s);
//         while(sb.indexOf("(")!=-1){
//             open = sb.lastIndexOf("(");
//             close = sb.indexOf(")",open);

//             String rev = new StringBuilder(sb.substring(open+1,close)).reverse().toString();

//             sb.replace(open,close+1,rev);
//         }

//         return sb.toString();

//     }
// }


class Solution {
    public String reverseParentheses(String s) {

        int n = s.length();
        Deque<Integer> stk = new ArrayDeque<>();
        int[] pair = new int[n];

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stk.push(i);
            }else if(ch == ')'){
                int open = stk.pop();
                pair[open] = i;
                pair[i] = open;
            }
        }

        StringBuilder sb = new StringBuilder();
        int direction = 1;

        for(int i=0; i<n; i += direction){
            
            char ch = s.charAt(i);

            if(ch == '(' || ch == ')'){
                i = pair[i];
                direction = -direction;
            }else{
                sb.append(ch);
            }

        }

        return sb.toString();
    }
}