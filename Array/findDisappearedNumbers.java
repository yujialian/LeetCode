class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int curIndex = Math.abs(nums[i]) - 1;
            if(nums[curIndex] > 0) nums[curIndex] = -nums[curIndex];
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) ans.add(i + 1);
        }
        
        return ans;
    }
}
