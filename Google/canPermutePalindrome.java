class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int numOfSingle = 0;
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(!map.containsKey(c) || map.containsKey(c) && map.get(c) % 2 == 0) numOfSingle++;
            else if(map.containsKey(c) && map.get(c) % 2 == 1) numOfSingle--;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return numOfSingle == 1 || numOfSingle == 0;
    }
}
