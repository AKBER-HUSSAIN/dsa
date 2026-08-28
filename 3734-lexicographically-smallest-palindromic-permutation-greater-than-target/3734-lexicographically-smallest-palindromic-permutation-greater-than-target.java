class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        int halfLen = n / 2;
        int[] halfCount = new int[26];

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
            halfCount[i] = count[i] / 2;
        }

        if ((n % 2 == 0 && oddCount > 0) || (n % 2 != 0 && oddCount != 1)) {
            return "";
        }

        char[] prefix = new char[halfLen];
        int pivot = -1;
        char pivotChar = 0;

        outer:
        for (int i = halfLen; i >= 0; i--) {
            int[] currentCount = halfCount.clone();
            boolean valid = true;
            for (int j = 0; j < i; j++) {
                char c = target.charAt(j);
                if (currentCount[c - 'a'] > 0) {
                    currentCount[c - 'a']--;
                    prefix[j] = c;
                } else {
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            if (i == halfLen) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < halfLen; j++) sb.append(prefix[j]);
                if (n % 2 != 0) sb.append(midChar);
                for (int j = halfLen - 1; j >= 0; j--) sb.append(prefix[j]);

                String candidate = sb.toString();
                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }
                continue;
            }

            char targetChar = target.charAt(i);
            for (int c = targetChar - 'a' + 1; c < 26; c++) {
                if (currentCount[c] > 0) {
                    pivot = i;
                    pivotChar = (char) ('a' + c);
                    break outer;
                }
            }
        }

        if (pivot == -1) {
            return "";
        }

        int[] currentCount = halfCount.clone();
        for (int j = 0; j < pivot; j++) {
            prefix[j] = target.charAt(j);
            currentCount[target.charAt(j) - 'a']--;
        }

        prefix[pivot] = pivotChar;
        currentCount[pivotChar - 'a']--;

        int idx = pivot + 1;
        for (int c = 0; c < 26; c++) {
            while (currentCount[c] > 0) {
                prefix[idx++] = (char) ('a' + c);
                currentCount[c]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < halfLen; j++) sb.append(prefix[j]);
        if (n % 2 != 0) sb.append(midChar);
        for (int j = halfLen - 1; j >= 0; j--) sb.append(prefix[j]);

        return sb.toString();
    }
}