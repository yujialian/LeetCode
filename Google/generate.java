//118
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) list.add(1);
                else if(!ans.isEmpty()) {
                    list.add(ans.get(ans.size() - 1).get(j - 1) + ans.get(ans.size() - 1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
