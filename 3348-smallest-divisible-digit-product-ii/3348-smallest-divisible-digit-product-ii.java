import java.util.*;

class Solution {
    // Prime factor representations for digits 0-9: {2s, 3s, 5s, 7s}
    private static final int[][] DIGIT_FACTORS = {
        {0, 0, 0, 0}, // 0
        {0, 0, 0, 0}, // 1
        {1, 0, 0, 0}, // 2
        {0, 1, 0, 0}, // 3
        {2, 0, 0, 0}, // 4
        {0, 0, 1, 0}, // 5
        {1, 1, 0, 0}, // 6
        {0, 0, 0, 1}, // 7
        {3, 0, 0, 0}, // 8
        {0, 2, 0, 0}  // 9
    };

    public String smallestNumber(String num, long t) {
        int[] reqPrimes = new int[4]; // 2, 3, 5, 7
        long tempT = t;
        int[] primes = {2, 3, 5, 7};
        
        for (int i = 0; i < 4; i++) {
            while (tempT % primes[i] == 0) {
                reqPrimes[i]++;
                tempT /= primes[i];
            }
        }
        
        // If t has prime factors other than 2, 3, 5, 7, it's impossible.
        if (tempT > 1) return "-1";

        int n = num.length();
        int[] factorCount = getFactorCount(reqPrimes);
        if (sumArray(factorCount) > n) {
            return construct(factorCount);
        }

        // Count prime factors present in prefix of num (up to first zero)
        int[] prefixPrimes = new int[4];
        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            if (d == 0) {
                firstZero = i;
                break;
            }
            for (int k = 0; k < 4; k++) {
                prefixPrimes[k] += DIGIT_FACTORS[d][k];
            }
        }

        // Check if `num` itself is valid (no zeros and product divisible by t)
        if (firstZero == -1) {
            boolean satisfied = true;
            for (int k = 0; k < 4; k++) {
                if (prefixPrimes[k] < reqPrimes[k]) {
                    satisfied = false;
                    break;
                }
            }
            if (satisfied) return num;
        }

        // Search for the longest common prefix from right to left
        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            
            // Skip indices after the first zero
            if (firstZero != -1 && i > firstZero) {
                continue;
            }

            // Remove digit i's factors ONLY if it was part of prefixPrimes (i.e. i < firstZero)
            if (d > 0 && (firstZero == -1 || i < firstZero)) {
                for (int k = 0; k < 4; k++) {
                    prefixPrimes[k] -= DIGIT_FACTORS[d][k];
                }
            }

            int spaceRemaining = n - 1 - i;

            // Try replacing digit at index i with a larger digit
            for (int nextDigit = d + 1; nextDigit < 10; nextDigit++) {
                int[] remPrimes = new int[4];
                for (int k = 0; k < 4; k++) {
                    remPrimes[k] = Math.max(0, reqPrimes[k] - prefixPrimes[k] - DIGIT_FACTORS[nextDigit][k]);
                }

                int[] neededFactors = getFactorCount(remPrimes);
                if (sumArray(neededFactors) <= spaceRemaining) {
                    int onesToFill = spaceRemaining - sumArray(neededFactors);
                    
                    StringBuilder sb = new StringBuilder();
                    sb.append(num.substring(0, i));
                    sb.append(nextDigit);
                    for (int j = 0; j < onesToFill; j++) {
                        sb.append('1');
                    }
                    sb.append(construct(neededFactors));
                    return sb.toString();
                }
            }
        }

        // If same length isn't possible, expand length
        int[] minFactors = getFactorCount(reqPrimes);
        int targetLength = Math.max(n + 1, sumArray(minFactors));
        int onesToFill = targetLength - sumArray(minFactors);

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < onesToFill; j++) {
            sb.append('1');
        }
        sb.append(construct(minFactors));
        return sb.toString();
    }

    private int[] getFactorCount(int[] primeCount) {
        int c2 = primeCount[0];
        int c3 = primeCount[1];
        int c5 = primeCount[2];
        int c7 = primeCount[3];

        int cnt8 = c2 / 3;
        c2 %= 3;

        int cnt9 = c3 / 2;
        c3 %= 2;

        int cnt4 = c2 / 2;
        c2 %= 2;

        int cnt6 = 0;
        if (c2 == 1 && c3 == 1) {
            c2 = 0;
            c3 = 0;
            cnt6 = 1;
        }

        if (c3 == 1 && cnt4 == 1) {
            c2 = 1;
            cnt6 = 1;
            c3 = 0;
            cnt4 = 0;
        }

        int[] factorCount = new int[10];
        factorCount[2] = c2;
        factorCount[3] = c3;
        factorCount[4] = cnt4;
        factorCount[5] = c5;
        factorCount[6] = cnt6;
        factorCount[7] = c7;
        factorCount[8] = cnt8;
        factorCount[9] = cnt9;

        return factorCount;
    }

    private String construct(int[] factorCount) {
        StringBuilder sb = new StringBuilder();
        for (int digit = 2; digit <= 9; digit++) {
            for (int i = 0; i < factorCount[digit]; i++) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    private int sumArray(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return sum;
    }
}