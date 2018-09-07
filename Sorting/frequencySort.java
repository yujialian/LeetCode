class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.offer(entry);
        }
        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
