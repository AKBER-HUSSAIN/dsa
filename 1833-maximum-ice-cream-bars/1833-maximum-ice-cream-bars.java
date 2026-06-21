class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int maxVal = costs[0];
        for(int x: costs) {
            maxVal = Math.max(maxVal,x);
        }

        int[] freq = new int[maxVal+1];

        for(int x: costs) {
            freq[x] += 1;
        }

        int totalCost = 0;
        int totalBought = 0;
        int i = 0;
        for(; i < freq.length; i++) {
            totalCost += freq[i] * i;
            if(totalCost > coins) {
                totalCost -= freq[i] * i;
                int availableCost = coins - totalCost;
                if(availableCost > 0 && i > 0) {
                    int canTake = availableCost/i;
                    if(canTake > 0) {
                        return totalBought + canTake;
                    }
                }
                return totalBought;
            } else {
                totalBought += freq[i];
            }
        }

        return totalBought;
    }

    public static int[] countingSort(int[] nums) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        for(int x: nums) {
            maxVal = Math.max(maxVal,x);
        }

        int[] countArray = new int[maxVal+1];

        for (int num : nums) {
            countArray[num] += 1;
        }

        for(int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }

        int[] sorted = new int[n];
        for(int i = n-1; i >= 0; i--) {
            countArray[nums[i]] -= 1;
            sorted[countArray[nums[i]]]  = nums[i];
        }

        return sorted;
    }
}