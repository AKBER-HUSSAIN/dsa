import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        // Use a HashSet for O(1) lookups of your friends
        Set<Integer> friendSet = new HashSet<>();
        for (int f : friends) {
            friendSet.add(f);
        }
        
        List<Integer> resultList = new ArrayList<>();
        // Iterate through the finishing order and pick out friends as they appear
        for (int id : order) {
            if (friendSet.contains(id)) {
                resultList.add(id);
            }
        }
        
        // Convert the List back to an int[] array
        int[] arr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            arr[i] = resultList.get(i);
        }
        
        return arr;
    }
}