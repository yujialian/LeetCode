class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() <= 2) return s.length();
        int l = 0, r = -1;
        int[] sFreq = new int[256];
        int distinctCount = 0;
        int maxLen = 0;
        while(r < s.length() - 1) {
            if(sFreq[s.charAt(r + 1)] == 0) {
                if(distinctCount < 2) {
                    sFreq[s.charAt(++r)]++;
                    distinctCount++;
                } else {
                    sFreq[s.charAt(l)]--;
                    if(sFreq[s.charAt(l)] == 0) {
                        distinctCount--;
                    }
                    l++;
                }
            } else {
                sFreq[s.charAt(++r)]++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}

