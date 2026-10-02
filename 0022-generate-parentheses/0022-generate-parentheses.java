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
        List<String> ans  = new ArrayList<>();
        solve(n, ans, 0, 0, "");
        return ans;
    }
    public static void solve(int n, List<String> ans, int open, int close, String cans){
        if(cans.length()==2*n){
            ans.add(cans);
            return;
        }

        if(open<n){
            solve(n, ans, open+1, close, cans+"(" );
        }

        if(close<open){
            solve(n, ans, open, close+1, cans+")");
        }


    }
}