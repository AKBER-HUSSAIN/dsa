import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        Set<Integer> pairs = new HashSet<>();
        BitSet ans = new BitSet();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        for (int x : pairs) {
            for (int v : nums) {
                ans.set(x ^ v);
            }
        }

        return ans.cardinality();
    }
}