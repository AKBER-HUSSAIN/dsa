class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,0,0,"",ans);
        return ans;
    }
    public static void solve(int n, int open, int close, String op, List<String> ans){
        if(op.length() == 2*n){
            ans.add(op);
            return;
        }

        if(open<n){
            solve(n,open+1,close,op+"(",ans);
        }

        if(close<open){
            solve(n,open,close+1,op+")",ans);
        }
    }
}