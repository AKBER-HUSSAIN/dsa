class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        solve(nums,ans,op,0);
        return ans;
    }
    public static void solve(int[] nums,List<List<Integer>> ans, List<Integer> op, int index){
        if(index>=nums.length){
            ans.add(new ArrayList<>(op));
            return;
        }
        solve(nums,ans,op,index+1);

        int val = nums[index];
        op.add(val);
        solve(nums,ans,op,index+1);

        op.remove(op.size()-1);
    }

}