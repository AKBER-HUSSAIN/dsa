import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> op = new ArrayList<>();
        int maxe = Integer.MIN_VALUE;
        int mine = Integer.MAX_VALUE;
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            maxe = Math.max(maxe,nums[i]);
            mine = Math.min(mine,nums[i]);
            s.add(nums[i]);
        }
        for(int i=mine; i<=maxe; i++){
            if(!s.contains(i)){
                op.add(i);
            }
        }
        return op;
    }
}