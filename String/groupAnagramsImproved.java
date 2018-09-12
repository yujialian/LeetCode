class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();
        int[] arr = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++) {
            Arrays.fill(arr, 0);
            char[] curStrChar = strs[i].toCharArray();
            for(int j = 0; j < curStrChar.length; j++) arr[curStrChar[j] - 'a']++;
            String series = "";
            for(int k = 0; k < arr.length; k++) {
                series += "#" + arr[k];
            }
            if(!map.containsKey(series)) map.put(series, new ArrayList<String>());
            map.get(series).add(strs[i]);
        }
        
        return new ArrayList(map.values());
    }
}
