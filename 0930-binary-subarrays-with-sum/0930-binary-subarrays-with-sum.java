// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         int n = nums.length;
//         int c=0;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];
//                 if(sum==goal){
//                     c++;
//                 }
//             }
//         }
//         return c;
//     }
// }

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum=0, count=0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(map.containsKey((sum-goal))){
                count+=map.get(sum-goal);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}