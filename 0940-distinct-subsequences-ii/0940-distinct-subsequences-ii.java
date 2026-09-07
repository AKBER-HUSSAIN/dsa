class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        // endWith[c] stores the number of distinct subsequences ending with character ('a' + c)
        long[] endWith = new long[26];
        
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            // Sum of all distinct subsequences formed so far plus 1 for the single-character subsequence "ch"
            long newSubseqs = 1;
            for (int i = 0; i < 26; i++) {
                newSubseqs = (newSubseqs + endWith[i]) % MOD;
            }
            endWith[idx] = newSubseqs;
        }
        
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + endWith[i]) % MOD;
        }
        
        return (int) total;
    }
}