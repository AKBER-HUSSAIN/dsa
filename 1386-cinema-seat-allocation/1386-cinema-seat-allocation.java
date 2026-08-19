import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << (col - 2)));
            }
        }

        int maxGroups = (n - map.size()) * 2;

        for (int mask : map.values()) {
            boolean leftAvailable = (mask & 0b00001111) == 0;
            boolean rightAvailable = (mask & 0b11110000) == 0;
            boolean middleAvailable = (mask & 0b00111100) == 0;

            if (leftAvailable && rightAvailable) {
                maxGroups += 2;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                maxGroups += 1;
            }
        }

        return maxGroups;
    }
}