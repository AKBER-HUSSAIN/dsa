class Solution {
    public int sumCounts(List<Integer> nums) {
     int total = 0;
     int n = nums.size();
     for(int i=0;i<n;i++){
        HashSet<Integer> st = new HashSet<>();
        for(int j=i;j<n;j++){
            st.add(nums.get(j));

            int s=st.size();
            total+=s*s;
        }
     }  
     return total;
    }
}