class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int index = 0;
        solve(nums,op,ans,index);
        return ans;
    }
    public static void solve(int[] nums, List<Integer> op, List<List<Integer>> ans, int index){
        if(index>=nums.length){
            ans.add(new ArrayList<>(op));
            return ;
        }

        solve(nums,op,ans,index+1);

        int ele = nums[index];
        op.add(ele);
        solve(nums,op,ans,index+1);

        op.remove(op.size() - 1);
    }
}