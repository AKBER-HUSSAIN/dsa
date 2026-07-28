class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        char mid = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < cnt[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
            if ((cnt[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }
        StringBuilder ans = new StringBuilder(left);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }
}