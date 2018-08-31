class Solution {
	public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        int[] sFreq = new int[256];
        int[] tFreq = new int[256];
        for(int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }
        int l = 0, r = -1;
        int minLen = s.length() + 1;
        int curCnt = 0;
        int startIndex = 0;
        while(l < s.length()) {
            if(r < s.length() - 1 && curCnt < t.length()) {
                sFreq[s.charAt(r + 1)]++;
                if(sFreq[s.charAt(r + 1)] <= tFreq[s.charAt(r + 1)]) {
                    curCnt++;
                }
                r++;
            } else {
                if(curCnt == t.length() && r - l + 1 < minLen) {
                    startIndex = l;
                    minLen = r - l + 1;
                }
                sFreq[s.charAt(l)]--;
                if(sFreq[s.charAt(l)] < tFreq[s.charAt(l)]) {
                    curCnt--;
                }
                l++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(startIndex, startIndex + minLen); 
	}
}
