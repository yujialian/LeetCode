class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        Map<String, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        /*Actually a tricky question, need use Integer rather than int, we want using object to see if the memory address between current element and previous element of pattern and words are stay same, if not they have different pattern.*/
        for(Integer i = 0; i < words.length; ++i) {
            
            if(map2.put(pattern.charAt(i), i) != (map1.put(words[i], i))) return false;
        }
        return true;
    }
}
