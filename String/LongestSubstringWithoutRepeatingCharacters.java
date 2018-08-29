class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int size = 0;
        int[] count = new int[256];
        /* There are 256 ASCII characters. */
        int l = 0, r = -1;
        while(l < s.length()) {
            if(r < s.length() - 1 && count[s.charAt(r + 1)] == 0) {
                count[s.charAt(++r)]++;
            } else {
                count[s.charAt(l++)]--;
            }
            size = Math.max(size, r - l + 1);
        }
        return size;
    }
}
