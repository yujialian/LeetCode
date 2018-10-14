class Solution {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() != s2.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        Set<String> set = new HashSet<>();
        for(String str: words) {
            pq.offer(str);
            set.add(str);
        }
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(!pq.isEmpty()) {
            String str = pq.poll();
            for(i = 0; i < str.length(); i++) {
                if(!set.contains(str.substring(0, i + 1))) break;
            }
            if(i == str.length()) return str;
        }
        return "";
    }
}
