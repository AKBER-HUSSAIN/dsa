class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        boolean[] isFriends = new boolean[n+1];
        for (int f : friends) {
            isFriends[f] = true;
        }
        int[] result = new int[friends.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (isFriends[order[i]] == true) result[index++] = order[i];
        }
        return result;
    }
}