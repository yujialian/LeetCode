class Solution {
    public boolean isPalindrome(String str) {
        String upperStr = str.toUpperCase();
        if(upperStr == null || upperStr.length() == 0) return true;
        int i = 0, j = upperStr.length() - 1;
        while(i < j) {
            while(i < j &&!Character.isLetterOrDigit(upperStr.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(upperStr.charAt(j))) j--;
            if(i >= j) return true;
            if(upperStr.charAt(i++) != upperStr.charAt(j--)) { return false; }
        }
        return true;
    }
}
