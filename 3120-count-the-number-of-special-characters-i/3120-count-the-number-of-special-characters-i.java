class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();

        for (char c : word.toCharArray())
            set.add(c);

        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (set.contains(c) && set.contains((char)(c - 'a' + 'A')))
                ans++;
        }

        return ans;
    }
}