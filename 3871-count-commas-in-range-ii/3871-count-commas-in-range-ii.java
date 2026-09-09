class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long base = 1000;
        
        while (n >= base) {
            ans += (n - base + 1);
            
            // Avoid potential 64-bit long overflow when base * 1000 exceeds Long.MAX_VALUE
            if (base > Long.MAX_VALUE / 1000) {
                break;
            }
            base *= 1000;
        }
        
        return ans;
    }
}