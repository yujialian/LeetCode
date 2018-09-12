class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if(strs == null || strs.length == 0) return ans;
        Map<String, List> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] curCharArr = strs[i].toCharArray();
            Arrays.sort(curCharArr);
            String converted = Arrays.toString(curCharArr);
            if(!map.containsKey(converted)) map.put(converted, new ArrayList<>());
            map.get(converted).add(strs[i]);
        }
        for(Map.Entry<String, List> entry: map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
