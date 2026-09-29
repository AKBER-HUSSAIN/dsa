// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<>();
//         solve(n,0,0,"",ans);
//         return ans;
//     }
//     public static void solve(int n, int open, int close, String op, List<String> ans){
//         if(op.length() == 2*n){
//             ans.add(op);
//             return;
//         }

//         if(open<n){
//             solve(n,open+1,close,op+"(",ans);
//         }

//         if(close<open){
//             solve(n,open,close+1,op+")",ans);
//         }
//     }
// }


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(0,0,n,ans,sb);
        return ans;
    }

    void dfs(int open,int closed,int n,List<String> ans,StringBuilder sb){
        if(open==n && closed==n){
            String s = sb.toString();
            ans.add(s);
            return;
        }
        if(open<n){
            sb.append('(');
            dfs(open+1,closed,n,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open>closed){
            sb.append(')');
            dfs(open,closed+1,n,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}