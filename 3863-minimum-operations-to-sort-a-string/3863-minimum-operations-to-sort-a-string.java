class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        
        char mn = s.charAt(0);
        char mx = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < mn) mn = c;
            if (c > mx) mx = c;
        }
        
        boolean mnAtStart = (s.charAt(0) == mn);
        boolean mxAtEnd = (s.charAt(n - 1) == mx);
        
        if (mnAtStart || mxAtEnd) {
            return 1;
        }
        
        boolean hasMnInProperPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == mn) {
                hasMnInProperPrefix = true;
                break;
            }
        }
        
        boolean hasMxInProperSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == mx) {
                hasMxInProperSuffix = true;
                break;
            }
        }
        
        if (!hasMnInProperPrefix && !hasMxInProperSuffix) {
            return 3;
        }
        
        return 2;
    }
}