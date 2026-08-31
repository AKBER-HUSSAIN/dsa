class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int lastIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) || 
                (curr.val < prev.val && curr.val < curr.next.val)) {
                
                if (firstIndex == -1) {
                    firstIndex = index;
                } else {
                    minDistance = Math.min(minDistance, index - lastIndex);
                }
                lastIndex = index;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstIndex == -1 || firstIndex == lastIndex) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastIndex - firstIndex;
        return new int[]{minDistance, maxDistance};
    }
}