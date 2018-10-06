class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++) {
                sb.append(MORSE[words[i].charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
