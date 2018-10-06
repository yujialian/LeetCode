class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int[] ans = new int[2];
        int total = 0;
        for(int i = 0; i < S.length(); i++) {
            if(total + widths[S.charAt(i) - 'a'] > 100) {
                ans[0]++;
                total = widths[S.charAt(i) - 'a'];
            } else {
                total += widths[S.charAt(i) - 'a'];
            }
        }
        if(total > 0) ans[0]++;
        ans[1] = total;
        return ans;
    }
}
