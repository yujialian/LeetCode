class Solution {
    public int minSubArrayLen(int s, int[] nums) {
		if( nums == null || nums.length == 0 ) return 0;
		int l = 0, r = -1;
		int curSum = 0;
		int size = nums.length + 1;
        while( l < nums.length ) {
            if(r < nums.length && curSum < s) {
                curSum += nums[++r];
            } else {
                curSum -= nums[l++];
            }
            if(curSum >= s) {
                size = Math.min(size, r - l + 1);
            }
        }
        if( size == nums.length + 1 ) return 0;
        return size;
    }
}
