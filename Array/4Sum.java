class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                for(int j = nums.length - 1; j > i + 2; j--) {
                    if(j == nums.length - 1 || nums[j] != nums[j + 1]) {
                        int remain = target - nums[i] - nums[j];
                        int start = i + 1;
                        int end = j - 1;
                        while(start < end) {
                            if(nums[start] + nums[end] == remain) {
                                res.add(Arrays.asList(nums[i], nums[start], nums[end], nums[j]));
                                do { start++; } while(start < end && nums[start] == nums[start - 1]);
                                do { end--; } while(start < end && nums[end] == nums[end + 1]);
                                
                            } else if(nums[start] + nums[end] < remain) {
                                start++;
                            } else end--;
                        }
                    }
                }
            }
        }
        return res;
    }
}
