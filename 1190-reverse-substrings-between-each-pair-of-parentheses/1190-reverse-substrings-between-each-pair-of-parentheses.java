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


import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                int start = stack.pop();
                reverse(sb, start, sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}