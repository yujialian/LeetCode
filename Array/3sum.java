class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i -1]) {
                int remain = 0 - nums[i];
                int l = i + 1, r = nums.length - 1;
                while(l < r) {
                    if(remain == (nums[l] + nums[r])) {
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if(remain < (nums[l] + nums[r])) r--;
                    else l++;
                }
            }
        }
        return ans;
    }
}
