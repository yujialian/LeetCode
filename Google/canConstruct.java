//383
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;
        int[] digits = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            digits[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            if(--digits[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
