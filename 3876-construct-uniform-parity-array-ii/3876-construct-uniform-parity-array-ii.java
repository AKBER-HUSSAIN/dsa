class Solution {
    public boolean uniformArray(int[] nums1) {
        int minAll = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num < minAll) {
                minAll = num;
            }
            if (num % 2 != 0) {
                if (num < minOdd) {
                    minOdd = num;
                }
            } else {
                if (num < minEven) {
                    minEven = num;
                }
            }
        }

        boolean canBeOdd = true;
        for (int num : nums1) {
            if (num % 2 == 0) {
                if (minOdd == Integer.MAX_VALUE || num <= minOdd) {
                    canBeOdd = false;
                    break;
                }
            }
        }

        boolean canBeEven = true;
        for (int num : nums1) {
            if (num % 2 != 0) {
                if (minOdd == Integer.MAX_VALUE || num <= minOdd) {
                    canBeEven = false;
                    break;
                }
            }
        }

        return canBeOdd || canBeEven;
    }
}