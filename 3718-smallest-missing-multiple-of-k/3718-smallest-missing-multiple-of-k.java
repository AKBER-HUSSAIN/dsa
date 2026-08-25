class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hset= new HashSet<>();
        for(int n:nums){
            hset.add(n);
        }
        int m = k;
        while(hset.contains(m)){
            m+=k;
        }
        return m;
    }
}