import java.util.HashMap;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // We have seen 0 odd numbers once
        map.put(0, 1);

        int oddCount = 0;
        int count = 0;

        for (int num : nums) {

            // Odd = 1
            // Even = 0
            if (num % 2 != 0) {
                oddCount++;
            }

            // We need an earlier prefix sum:
            // current - old = k
            //
            // old = current - k
            int needed = oddCount - k;

            if (map.containsKey(needed)) {
                count += map.get(needed);
            }

            // Remember this prefix sum
            map.put(oddCount,
                    map.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}
