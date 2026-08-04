// import java.util.*;
// class Solution {
//     public List<Integer> findMissingElements(int[] nums) {
//         List<Integer> op = new ArrayList<>();
//         int maxe = Integer.MIN_VALUE;
//         int mine = Integer.MAX_VALUE;
//         Set<Integer> s = new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             maxe = Math.max(maxe,nums[i]);
//             mine = Math.min(mine,nums[i]);
//             s.add(nums[i]);
//         }
//         for(int i=mine; i<=maxe; i++){
//             if(!s.contains(i)){
//                 op.add(i);
//             }
//         }
//         return op;
//     }
// }


class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];

        for(int i : nums){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int[] arr = new int[max + 1];
        for(int i : nums){
            arr[i]++;
        }

        for(int i=min;i<max;i++){
            if(arr[i] == 0)
                ans.add(i);
        }
        return ans;


    }
}