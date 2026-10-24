class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int leftIdx = 0, rightIdx = nums.length - 1;

        while (left < nums.length) {
            if (nums[left] < pivot) {
                result[leftIdx++] = nums[left];
            }
            if (nums[right] > pivot) {
                result[rightIdx--] = nums[right];
            }
            left++;
            right--;
        }

        while (leftIdx <= rightIdx) {
            result[leftIdx++] = pivot;
        }

        return result;
    }
}