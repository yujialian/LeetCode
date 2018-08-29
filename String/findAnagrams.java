 public class Solution {
     public List<Integer> findAnagrams(String s, String p) {
         List<Integer> ans = new ArrayList<>();
         if(s.length() < p.length()) return ans;
         assert(p.length() > 0);
         int[] freq = new int[26];
         for(char c: p.toCharArray()) {
             freq[c - 'a']++;
         }
         int[] freqActual = new int[26];
         int l = 0, r = -1; //Slide window, s[l, r].
         while(r < s.length() - 1) {
             freqActual[s.charAt(++r) - 'a']++;
             if(r - l + 1 > p.length()) freqActual[s.charAt(l++) - 'a']--;
             if(r - l + 1 == p.length() && same(freqActual, freq)) {
                 ans.add(l);
             }
         }
         return ans;
     }
     private boolean same(int[] arr1, int[] arr2) {
         if(arr1 == null || arr2 == null) return false;
         if(arr1.length != arr2.length) return false;
         for(int i = 0; i < arr1.length; i++) {
             if(arr1[i] != arr2[i]) return false;
         }
         return true;
     }
 }
