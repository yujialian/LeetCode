class Solution {
    public int jump(int[] nums) {
        int maxReach = 0, jumps = 0, reachable = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if(i == reachable) {
                jumps++;
                reachable = maxReach;
            }
        }
        
        return jumps;
    }
}
