//213
class Solution {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    private int rob(int[] nums, int l, int r) {
        int rob = 0;//Rob i - 1
        int notRob = 0; //Not rob i - 1
        for(int i = l; i <= r; i++) {
            int robCurr = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = robCurr;
        }
        return Math.max(rob, notRob);
    }
}
