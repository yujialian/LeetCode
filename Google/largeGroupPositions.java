class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        for(int j = 0; j < S.length(); j++) {
            if(j == S.length() - 1 || S.charAt(j) != S.charAt(j + 1)) {
                if(j - i + 1 >= 3) ans.add(Arrays.asList(new Integer[] {i, j}));
                i = j + 1;
            }
        }
        return ans;
    }
}
