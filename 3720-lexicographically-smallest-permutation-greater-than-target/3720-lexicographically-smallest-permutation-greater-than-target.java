class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] tempFreq = freq.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';
                if (tempFreq[c] > 0) {
                    tempFreq[c]--;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int next = targetChar + 1; next < 26; next++) {
                if (tempFreq[next] > 0) {
                    tempFreq[next]--;
                    StringBuilder sb = new StringBuilder();
                    sb.append(target.substring(0, i));
                    sb.append((char) ('a' + next));
                    for (int ch = 0; ch < 26; ch++) {
                        while (tempFreq[ch] > 0) {
                            sb.append((char) ('a' + ch));
                            tempFreq[ch]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return "";
    }
}